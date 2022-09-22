package com.bits.bee.bpmc.presentation.ui.setting_lisensi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.remote.model.DetachPost
import com.bits.bee.bpmc.data.data_source.remote.response.CashierStatusResponse
import com.bits.bee.bpmc.data.data_source.remote.response.DetachResponse
import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.Sync
import com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetActivePossesListUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveLicenseUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.DetachCashierUseCase
import com.bits.bee.bpmc.domain.usecase.setting.help.DetachLicenseUseCase
import com.bits.bee.bpmc.domain.usecase.setting.help.GetHaventUploadedManualSyncUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.login_operator.LoginOperatorViewModel
import com.bits.bee.bpmc.presentation.ui.setting_list.SettingListViewModel
import com.bits.bee.bpmc.utils.ConnectionUtils
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingLisensiViewModel @Inject constructor(
    private val getActiveLicenseUseCase: GetActiveLicenseUseCase,
    private val getActivePossesListUseCase: GetActivePossesListUseCase,
    private val getHaventUploadedManualSyncUseCase: GetHaventUploadedManualSyncUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val detachCashierUseCase: DetachCashierUseCase,
    private val detachLicenseUseCase: DetachLicenseUseCase
): BaseViewModel<SettingLisensiState, SettingLisensiViewModel.UIEvent>() {

    private var mPossesList: List<Posses>? = null
    private var mSyncList: List<Sync>? = null

    init {
        state = SettingLisensiState()
    }

    private var cashierStatusResponse: MediatorLiveData<Resource<CashierStatusResponse>> = MediatorLiveData()
    fun observeCashierStatusResponse() = cashierStatusResponse as LiveData<Resource<CashierStatusResponse>>

    private var detachResponse: MediatorLiveData<Resource<DetachResponse>> = MediatorLiveData()
    fun observeDetachResponse() = detachResponse as LiveData<Resource<DetachResponse>>

    fun getLicense() = viewModelScope.launch {
        val license : License = getActiveLicenseUseCase().first() ?: throw Exception("No Active License!")
        updateState(
            state.copy(
                lisensi = license
            )
        )
    }

    fun getCashier() = viewModelScope.launch {
        getActiveCashierUseCase().first()?.let {
            updateState(
                state.copy(
                    cashier = it
                )
            )
        }
    }

    fun lepasLisensi() = viewModelScope.launch {
        getActivePossesListUseCase.invoke().collect {
            it.data?.let {
                mPossesList = it
            }
        }
        if (mPossesList!!.size > 0){
            eventChannel.send(UIEvent.RequestInfoTutupKasir)
            return@launch
        }

        getHaventUploadedManualSyncUseCase.invoke(40, 0).collect {
            it.data?.let {
                mSyncList = it
            }
        }
        if (mSyncList!!.size > 0){
            eventChannel.send(UIEvent.RequestSyncData)
            return@launch
        }

        if (mPossesList!!.size == 0 && mSyncList!!.size == 0){
            if (ConnectionUtils.isInternetAvailable()){
                deactiveStatusCashier()
            }
        }
    }

    private fun deactiveStatusCashier() = viewModelScope.launch {
        val source = detachCashierUseCase.invoke(state.cashier!!, "").asLiveData()
        cashierStatusResponse.addSource(source){
            if (it != null) {
                cashierStatusResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    cashierStatusResponse.removeSource(source)
                }
            } else {
                cashierStatusResponse.removeSource(source)
            }
        }
    }

    fun detachLicense() = viewModelScope.launch {
        val detachPost = DetachPost(
            license = state.lisensi!!.licNumber
        )

        val source = detachLicenseUseCase.invoke(detachPost).asLiveData()
        detachResponse.addSource(source){
            if (it != null) {
                detachResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    detachResponse.removeSource(source)
                }
            } else {
                detachResponse.removeSource(source)
            }
        }

    }

    fun perpanjangLisensi() = viewModelScope.launch {

    }

    fun manualSync(){

    }

    fun confirmDetachLicense() = viewModelScope.launch {
        eventChannel.send(UIEvent.ConfirmDetachLicense)
    }

    fun onSuccesDetach() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToLogin)
    }

    sealed class UIEvent {
        object RequestInfoTutupKasir : UIEvent()
        object RequestSyncData : UIEvent()
        object ConfirmDetachLicense : UIEvent()
        object NavigateToLogin : UIEvent()
    }
}