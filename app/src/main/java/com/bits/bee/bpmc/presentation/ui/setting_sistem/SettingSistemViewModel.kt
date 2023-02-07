package com.bits.bee.bpmc.presentation.ui.setting_sistem

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingSistemViewModel @Inject constructor(
    @ApplicationContext val application: Context,
    private val beePreferenceManager: BeePreferenceManager
): BaseViewModel<SettingSistemState, SettingSistemViewModel.UIEvent>() {

    val sistemPreferences = beePreferenceManager.sistemPreferences

    init {
        state = SettingSistemState()
    }

    fun onClickSistemPenyimpanan() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestSistemPenyimpanan)
    }

    fun onClickSistemBatchUpload() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestSistemBatchUpload)
    }

    fun onClickPeriodeUploadOtomatis() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestPeriodeUploadOtomatis)
    }

    fun onClickAboutCloudDapur() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestAboutCloudDapur)
    }

    fun onClickCloudDapur(value: Boolean) = viewModelScope.launch {
        onUpdateSistemPreferences(sistemPreferences.first().copy(
            isCloudDapur = value
        ))
    }

    fun onClickAturPrinter() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestSettingPritner)
    }

    fun onSuccessSistemPenyimpanan(value : String) = viewModelScope.launch {
        onUpdateSistemPreferences(sistemPreferences.first().copy(
            penyimpanan = value
        ))
    }

    fun onSuccessSistemBatchUpload(value : String) = viewModelScope.launch {
        onUpdateSistemPreferences(sistemPreferences.first().copy(
            batchUpload = value
        ))
    }

    fun onSuccessSistemUploadOtomatis(value : String) = viewModelScope.launch {
        onUpdateSistemPreferences(sistemPreferences.first().copy(
            periodeUpload = value
        ))
    }


    private fun onUpdateSistemPreferences(sistemPreferences: BeePreferenceManager.SistemPreferences) = viewModelScope.launch {
        beePreferenceManager.updateSistemPreferences(sistemPreferences)
    }

    sealed class UIEvent{
        object RequestSistemPenyimpanan : UIEvent()
        object RequestSistemBatchUpload : UIEvent()
        object RequestPeriodeUploadOtomatis : UIEvent()
        object RequestAboutCloudDapur : UIEvent()
        object RequestSettingPritner: UIEvent()
    }
}