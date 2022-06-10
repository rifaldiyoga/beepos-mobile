package com.bits.bee.bpmc.presentation.ui.setting_printer

import android.os.Build
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.bits.bee.bpmc.domain.usecase.printer.PrinterInteractor
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
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

    fun loadFromState(data: List<Printer>){
//        state.mlistPrinter?.let {
//            checkDuplicatePrinter(it)
//        }
        checkDuplicatePrinter(data)
    }

    private fun checkDuplicatePrinter(list: List<Printer>){
        for(p in list){
            if (!printList.contains(p)){
                printList.add(p)
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            printList = printList.stream().distinct().collect(Collectors.toList<Any>()) as MutableList<Printer>
        }
    }

    fun get(): List<Printer>{
        return printList
    }

    fun onClickAddPrinter() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestAddPrinter)
    }

    fun update(state: SettingPrinterState){
        _state.update {
            state
        }
    }

    sealed class UIEvent{
        object RequestAddPrinter: UIEvent()
    }
}