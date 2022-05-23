package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddPrinterViewModel @Inject constructor(

): BaseViewModel<AddPrinterState, AddPrinterViewModel.UIEvent>() {

    init {
        state = AddPrinterState()
    }

    fun onClickShowPrinter() = viewModelScope.launch{
        eventChannel.send(UIEvent.RequestTipePrinter)
    }

    fun update(state: AddPrinterState){
        _state.update {
            state
        }
    }

    sealed class UIEvent{
        object RequestTipePrinter : UIEvent()
        object RequestSimpan : UIEvent()
    }
}