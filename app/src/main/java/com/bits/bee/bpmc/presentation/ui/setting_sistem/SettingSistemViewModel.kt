package com.bits.bee.bpmc.presentation.ui.setting_sistem

import android.content.Context
import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel
import com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewState
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingSistemViewModel @Inject constructor(
    @ApplicationContext val application: Context
): ViewModel() {
    private val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    private var _state = MutableStateFlow(SettingSistemState())
    var state = _state.asStateFlow()

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

    fun getSistemPenyimpanan() {
        _state.update { it.copy(sistemPenyimpanan = BeePreferenceManager.getDataFromPreferences(application, application.getString(
            R.string.pref_sistem_penyimpanan), "") as String) }
    }

    fun getSistemBatchUpload(){
        _state.update { it.copy(sistemBatchUpload = BeePreferenceManager.getDataFromPreferences(application, application.getString(
            R.string.pref_batch_upload), "" ) as String ) }
    }

    fun getPeriodeOtomatis(){
        _state.update { it.copy(periodeUploadOtomatis = BeePreferenceManager.getDataFromPreferences(application, application.getString(
            R.string.pref_periode_upload_otomatis), "") as String) }
    }

    fun onSwitchDataDapur(){
        _state.update { it.copy(isCloudDapur = true) }
    }

    fun offSwitchDataDapur(){
        _state.update { it.copy(isCloudDapur = false) }
    }

    sealed class UIEvent{
        object RequestSistemPenyimpanan : UIEvent()
        object RequestSistemBatchUpload : UIEvent()
        object RequestPeriodeUploadOtomatis : UIEvent()
        object RequestAboutCloudDapur : UIEvent()
    }
}