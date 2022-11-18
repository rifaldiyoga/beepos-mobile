package com.bits.bee.bpmc.presentation.ui.setting_printer

import android.os.Build
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.usecase.printer.PrinterInteractor
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.stream.Collectors
import javax.inject.Inject

@HiltViewModel
class SettingPrinterViewModel @Inject constructor(
    printerInteractor: PrinterInteractor
): BaseViewModel<SettingPrinterState, SettingPrinterViewModel.UIEvent>() {

    private var printList = mutableListOf<Printer>()
    private var mPrinterInteractor: PrinterInteractor

    init {
        state = SettingPrinterState()
        mPrinterInteractor = printerInteractor
    }

    val loadPrinter = mPrinterInteractor.loadPrinter()

    fun onClickAddPrinter() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestAddPrinter)
    }

    sealed class UIEvent{
        object RequestAddPrinter: UIEvent()
    }
}