package com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindPrinterViewModel @Inject constructor(

): BaseViewModel<ListPrinter, FindPrinterViewModel.UIEvent>() {

    init {
        state = ListPrinter()
    }

    fun onClickBackAddPrinter() = viewModelScope.launch {

    }

    sealed class UIEvent{
        object RequestAddPrinter : UIEvent()
    }
}