package com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search

import android.bluetooth.BluetoothDevice
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindPrinterViewModel @Inject constructor(

): BaseViewModel<FindPrinterState, FindPrinterViewModel.UIEvent>() {

    init {
        state = FindPrinterState()
    }

    fun addDiscoverPrint(name : String?, address : String) = viewModelScope.launch {
        val deviceList : MutableList<PrinterDevice> = mutableListOf()
        deviceList.addAll(state.deviceList)
        if(deviceList.firstOrNull { it.address == address } == null) {
            deviceList.add(PrinterDevice(name ?: "", address))
            updateState(
                state.copy(
                    deviceList = deviceList
                )
            )
        }
    }

    sealed class UIEvent {
        object RequestAddPrinter : UIEvent()
    }
}