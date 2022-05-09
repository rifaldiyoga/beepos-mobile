package com.bits.bee.bpmc.presentation.ui.setting_sistem

import android.content.Context
import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.setting_nota.SettingNotaState
import com.bits.bee.bpmc.presentation.ui.setting_nota.SettingNotaViewModel
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
): BaseViewModel<SettingSistemState, SettingSistemViewModel.UIEvent>() {

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

    fun update(state: SettingSistemState){
        _state.update {
            state
        }
    }

    sealed class UIEvent{
        object RequestSistemPenyimpanan : UIEvent()
        object RequestSistemBatchUpload : UIEvent()
        object RequestPeriodeUploadOtomatis : UIEvent()
        object RequestAboutCloudDapur : UIEvent()
    }
}