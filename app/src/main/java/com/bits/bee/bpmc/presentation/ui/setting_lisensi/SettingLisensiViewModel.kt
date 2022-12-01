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
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.DetachCashierUseCase
import com.bits.bee.bpmc.domain.usecase.setting.help.DetachLicenseUseCase
import com.bits.bee.bpmc.domain.usecase.setting.help.GetHaventUploadedManualSyncUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.ConnectionUtils
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
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
    private val detachLicenseUseCase: DetachLicenseUseCase,
    private val beePreferenceManager: BeePreferenceManager
): BaseViewModel<SettingLisensiState, SettingLisensiViewModel.UIEvent>() {

    private var mPossesList: List<Posses> = mutableListOf()
    private var mSyncList: List<Sync>? = null

    init {
        state = SettingLisensiState()
    }

    private var cashierStatusResponse: MediatorLiveData<Resource<CashierStatusResponse>> = MediatorLiveData()
    fun observeCashierStatusResponse() = cashierStatusResponse as LiveData<Resource<CashierStatusResponse>>

    private var detachLicenseResponse: MediatorLiveData<Resource<DetachResponse>> = MediatorLiveData()
    fun observeDetachResponse() = detachLicenseResponse as LiveData<Resource<DetachResponse>>

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
        getActivePossesListUseCase.invoke().collect{
            it.data?.let {
                mPossesList = it
            }
        }

        if (mPossesList.isNotEmpty()){
            eventChannel.send(UIEvent.RequestInfoTutupKasir)
            return@launch
        }

        getHaventUploadedManualSyncUseCase.invoke(40, 0).collect {
            it.data?.let {
                mSyncList = it
            }
        }
        if (mSyncList!!.isNotEmpty()){
            eventChannel.send(UIEvent.RequestSyncData)
            return@launch
        }

        if (mPossesList.isEmpty() && mSyncList!!.isEmpty()){
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
        detachLicenseResponse.addSource(source){
            if (it != null) {
                detachLicenseResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    detachLicenseResponse.removeSource(source)
                }
            } else {
                detachLicenseResponse.removeSource(source)
            }
        }

    }

    fun clearDataStore() = viewModelScope.launch {
        beePreferenceManager.clearPreferences()
    }

    fun perpanjangLisensi() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestPerpanjang)
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
        object RequestPerpanjang : UIEvent()
        object ConfirmDetachLicense : UIEvent()
        object NavigateToLogin : UIEvent()
    }
}