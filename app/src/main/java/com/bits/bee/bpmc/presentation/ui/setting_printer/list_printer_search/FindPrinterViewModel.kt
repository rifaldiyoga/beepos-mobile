package com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search

import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FindPrinterViewModel @Inject constructor(

): BaseViewModel<FindPrinterState, FindPrinterViewModel.UIEvent>() {

    init {
        state = FindPrinterState()
    }

    sealed class UIEvent {
        object RequestAddPrinter : UIEvent()
    }
}