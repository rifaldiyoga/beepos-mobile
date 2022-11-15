package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.domain.usecase.printer.GetKategoriPrinterKitchenUseCase
import com.bits.bee.bpmc.domain.usecase.printer.GetListKitchenUseCase
import com.bits.bee.bpmc.domain.usecase.printer.PrinterInteractor
import com.bits.bee.bpmc.domain.usecase.printer.SavePrinterUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.service.BluetoothConnectService
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPrinterViewModel @Inject constructor(
    private val printerInteractor: PrinterInteractor,
    private val savePrinterUseCase: SavePrinterUseCase,
    private val getListKitchenUseCase: GetListKitchenUseCase,
    val bluetoothConnectService: BluetoothConnectService,
    private val beePreferenceManager: BeePreferenceManager
): BaseViewModel<AddPrinterState, AddPrinterViewModel.UIEvent>() {

    init {
        state = AddPrinterState()
    }

    val sistemPreferences = beePreferenceManager.sistemPreferences

    fun loadData() = viewModelScope.launch {
        val sistemPreferences = sistemPreferences.first()
    }

    fun onClickPrinterKasir(b : Boolean) = viewModelScope.launch {
        updateState(
            state.copy(
                mPrinter = state.mPrinter?.copy(isReceipt = b)
            )
        )
        if(b)
            onClickAddKitchen()
        else
            clearPrinterKitchen()
    }

    fun onClickPrinterSetoran(b : Boolean) = viewModelScope.launch {
        updateState(
            state.copy(
                mPrinter = state.mPrinter?.copy(isReport = b)
            )
        )
    }

    fun onClickPrinterKitchen(b : Boolean) = viewModelScope.launch {
        updateState(
            state.copy(
                mPrinter = state.mPrinter?.copy(isKitchen = b)
            )
        )
    }

    fun onClickTesPrint() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestTesPrint)
    }

    fun onClickRadio(value : String) = viewModelScope.launch {
        updateState(
            state.copy(
                mPrinter = state.mPrinter?.copy(size = value)
            )
        )
    }

    fun onClickAddKitchen() = viewModelScope.launch {
        val printerKitchen = PrinterKitchen(kitchenName = "Makanan")
        val printerKitchenList = mutableListOf<PrinterKitchen>()
        printerKitchenList.addAll(state.printerKitchenList)
        printerKitchenList.add(printerKitchen)
        updateState(
            state.copy(
                printerKitchenList = printerKitchenList
            )
        )
    }

    fun onClickMinusKitchen() = viewModelScope.launch {
        if(state.printerKitchenList.isNotEmpty()) {
            val printerKitchenList = mutableListOf<PrinterKitchen>()
            printerKitchenList.addAll(state.printerKitchenList)
            printerKitchenList.removeAt(printerKitchenList.size - 1)
            updateState(
                state.copy(
                    printerKitchenList = printerKitchenList,
                    isKitchen = printerKitchenList.isNotEmpty()
                )
            )
        }
    }


    private fun clearPrinterKitchen() = viewModelScope.launch {
        updateState(
            state.copy(printerKitchenList = mutableListOf())
        )

//        val printerKitchenL = state.printerKitchenList
//        for (printK in printerKitchenL){
//            printK.id.let { deletePrinterKitD(it) }
//            deletePrinterKit(printK)
//        }
    }

    private fun deletePrinterKitD(id: Int) = viewModelScope.launch{
        printerInteractor.deletePrinterKitchenD(id)
    }

    private fun deletePrinterKit(printK: PrinterKitchen) = viewModelScope.launch{
        printerInteractor.deletePrinterKit(printK)
    }

    fun doSave() = viewModelScope.launch {
        state.mPrinter?.let {
            savePrinterUseCase(it, state.printerKitchenList)
            eventChannel.send(UIEvent.RequestSimpan)
        }
    }

    fun setPrinterKitchen(mPrinter: Printer?) = viewModelScope.launch {
        printerInteractor.getPrinterFromPrinterKitchen(mPrinter!!.id!!).collect {

            updateState(
                state.copy(printerKitchenList = it)
            )

        }
    }

    fun onClickShowPrinter() = viewModelScope.launch{
        eventChannel.send(UIEvent.RequestTipePrinter)
    }

    sealed class UIEvent{
        object RequestTipePrinter : UIEvent()
        object RequestSimpan : UIEvent()
        object RequestTesPrint : UIEvent()
    }
}