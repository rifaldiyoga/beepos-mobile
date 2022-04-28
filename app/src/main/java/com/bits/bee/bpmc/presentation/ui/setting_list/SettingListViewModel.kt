package com.bits.bee.bpmc.presentation.ui.setting_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.ui.login.LoginViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * Created by aldi on 05/04/22.
 */
class SettingListViewModel : ViewModel() {

    private val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    fun onClickSettingPos() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSettingPos)
    }

    fun onClickSettingFavorit() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSettingFavorit)
    }

    fun onClickSettingNota() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSettingNota)
    }

    fun onClickSettingPrint() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSettingPrint)
    }

    fun onClickSettingSistem() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSettingSistem)
    }

    fun onClickSettingLisensi() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSettingLisensi)
    }

    sealed class UIEvent {
        object NavigateToSettingPos : UIEvent()
        object NavigateToSettingFavorit : UIEvent()
        object NavigateToSettingNota : UIEvent()
        object NavigateToSettingPrint : UIEvent()
        object NavigateToSettingSistem : UIEvent()
        object NavigateToSettingLisensi : UIEvent()
    }

}