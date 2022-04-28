package com.bits.bee.bpmc.presentation.ui.pos.invoice

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.pos.pos.PosViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 25/04/22.
 */
@HiltViewModel
class InvoiceViewModel @Inject constructor() : BaseViewModel(){

    private val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    fun onClickBayar() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestPembayaran)
    }

    fun onClickBatal() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestBatal)
    }

    sealed class UIEvent {
        object RequestPembayaran : UIEvent()
        object RequestBatal : UIEvent()
    }

}