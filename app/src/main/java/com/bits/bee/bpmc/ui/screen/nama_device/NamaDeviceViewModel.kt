package com.bits.bee.bpmc.ui.screen.nama_device

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 21/03/22.
 */
@HiltViewModel
class NamaDeviceViewModel @Inject constructor(

): ViewModel() {

    private val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    var email : String = ""
    var password : String = ""
    var deviceName : String = ""

    fun onClickLanjutkan() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPilihDb)
    }

    sealed class UIEvent{
        object NavigateToPilihDb : UIEvent()
    }

}