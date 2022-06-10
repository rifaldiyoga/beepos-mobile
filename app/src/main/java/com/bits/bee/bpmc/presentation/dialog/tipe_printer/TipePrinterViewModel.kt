package com.bits.bee.bpmc.presentation.dialog.tipe_printer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class TipePrinterViewModel @Inject constructor(

): BaseViewModel<ListTipe,TipePrinterViewModel.UIEvent>() {

    fun OnClickLoadPrinter() = viewModelScope.launch{
        eventChannel.send(UIEvent.RequestSearchPrinterBluetooth)
    }

    sealed class UIEvent{
        object RequestSearchPrinterBluetooth : UIEvent()
    }
}