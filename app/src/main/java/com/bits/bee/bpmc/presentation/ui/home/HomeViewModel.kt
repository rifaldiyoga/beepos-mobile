package com.bits.bee.bpmc.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.domain.usecase.common.CheckLicenseUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveLicenseUseCase
import com.bits.bee.bpmc.domain.usecase.common.PostLicenseUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.getDateDiff
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 14/06/22.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager,
    private val checkLicenseUseCase: CheckLicenseUseCase,
    private val postLicenseUseCase: PostLicenseUseCase,
    private val getActiveLicenseUseCase: GetActiveLicenseUseCase
) : BaseViewModel<HomeState, HomeViewModel.UIEvent>() {

    private val _posModeState = MutableStateFlow(PosModeState.FnBState)

    @OptIn(FlowPreview::class)
    val posModeState : StateFlow<PosModeState> = _posModeState
        .filterNotNull()
        .flatMapConcat { beePreferenceManager.modePreferences }
        .stateIn(viewModelScope, SharingStarted.Lazily, PosModeState.FnBState)

    val license = getActiveLicenseUseCase()

    private var checkLicResponse: MediatorLiveData<Resource<List<License>>> = MediatorLiveData()
    fun observeLicense() = checkLicResponse as LiveData<Resource<List<License>>>

    private var reactiveLicResponse: MediatorLiveData<Resource<License>> = MediatorLiveData()
    fun observeReactiveLicense() = reactiveLicResponse as LiveData<Resource<License>>

    init {
        state = HomeState()
        validateLicense()
    }

    fun validateLicense() = viewModelScope.launch {
        val license = license.first()
        license?.let {
            updateState(
                state.copy(
                    activeLicense = it,
                    isShowLicense = getDateDiff(Date(), it.licExp ?: Date()) <= 14
                )
            )
        }
    }

    fun checkLicense(deviceInfo : String) = viewModelScope.launch{
        val source = checkLicenseUseCase(deviceInfo).asLiveData()
        checkLicResponse.addSource(source){
            if (it != null) {
                checkLicResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    checkLicResponse.removeSource(source)
                }
            } else {
                checkLicResponse.removeSource(source)
            }
        }
    }

    fun reactiveLicense(deviceInfo : String, version : String) = viewModelScope.launch{
        val source = postLicenseUseCase(deviceName = deviceInfo, version = version, reactive = true).asLiveData()
        reactiveLicResponse.addSource(source){
            if (it != null) {
                reactiveLicResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    reactiveLicResponse.removeSource(source)
                }
            } else {
                reactiveLicResponse.removeSource(source)
            }
        }
    }

    fun onPosClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPos)
    }

    sealed class UIEvent {
        object NavigateToPos : UIEvent()
    }

}