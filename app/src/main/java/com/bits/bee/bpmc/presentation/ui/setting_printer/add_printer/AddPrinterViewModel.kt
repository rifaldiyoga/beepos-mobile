package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.domain.usecase.printer.DeletePrinterUseCase
import com.bits.bee.bpmc.domain.usecase.printer.PrinterInteractor
import com.bits.bee.bpmc.domain.usecase.printer.SavePrinterUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.service.BluetoothConnectService
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPrinterViewModel @Inject constructor(
    private val printerInteractor: PrinterInteractor,
    private val savePrinterUseCase: SavePrinterUseCase,
    private val deletePrinterUseCase: DeletePrinterUseCase,
    val bluetoothConnectService: BluetoothConnectService,
    private val beePreferenceManager: BeePreferenceManager
): BaseViewModel<AddPrinterState, AddPrinterViewModel.UIEvent>() {

    init {
        state = AddPrinterState()
    }

    val modePreferences = beePreferenceManager.modePreferences

    fun onClickDelete() = viewModelScope.launch {
        state.mPrinter?.let {
            deletePrinterUseCase(it)
            eventChannel.send(UIEvent.NavigateBack)
        }
    }

    fun onClickPrinterKasir(b : Boolean) = viewModelScope.launch {
        updateState(
            state.copy(
                mPrinter = state.mPrinter?.copy(isReceipt = b)
            )
        )
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
        if(b)
            onClickAddPrinterKitchen()
        else
            clearPrinterKitchen()
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

    fun onClickAddPrinterKitchen() {
        val printerKitchen = PrinterKitchen()
        val printerKitchenList = mutableListOf<PrinterKitchen>()
        printerKitchenList.addAll(state.printerKitchenList)
        printerKitchenList.add(printerKitchen)
        updateState(
            state.copy(
                printerKitchenList = printerKitchenList,
                mPrinter = state.mPrinter?.copy(isKitchen = printerKitchenList.isNotEmpty())
            )
        )
    }

    fun onClickMinuPrintersKitchen() = viewModelScope.launch {
        if(state.printerKitchenList.isNotEmpty()) {
            val printerKitchenList = mutableListOf<PrinterKitchen>()
            printerKitchenList.addAll(state.printerKitchenList)
            printerKitchenList.removeAt(printerKitchenList.size - 1)
            updateState(
                state.copy(
                    printerKitchenList = printerKitchenList,
                    mPrinter = state.mPrinter?.copy(isKitchen = printerKitchenList.isNotEmpty())
                )
            )
        }
    }

    fun onClickAddKitchen(printerKitchen : PrinterKitchen) = viewModelScope.launch {
        val printerKitchenList = mutableListOf<PrinterKitchen>()
        printerKitchenList.addAll(state.printerKitchenList)
        printerKitchenList.first { it == printerKitchen  }.kitchenList = printerKitchen.kitchenList
        updateState(
            state.copy(
                printerKitchenList = printerKitchenList
            )
        )
    }

    private fun clearPrinterKitchen() = viewModelScope.launch {
        updateState(
            state.copy(printerKitchenList = mutableListOf())
        )
    }

    fun doSave() = viewModelScope.launch {
        state.mPrinter?.let {
            var errorName = ""
            var errorAddress = ""
            var isValid = true
            if(it.printerName.isEmpty()){
                isValid = false
                errorName = "Nama printer tidak boleh kosong!"
            }
            if(it.address.isEmpty()){
                isValid = false
                errorAddress = "Mac Address tidak boleh kosong!"

            }
            updateState(
                state.copy(
                    errorName = errorName,
                    errorAddress = errorAddress,
                )
            )
            if(state.printerKitchenList.isNotEmpty()) {
                state.printerKitchenList.forEach {
                    isValid = it.kitchenName.isNotEmpty() && it.kitchenList.isNotEmpty()
                }
                if(!isValid)
                    sendMessage("Pastikan nama dapur dan kategori terisi semua!")
            }
            if(isValid) {
                savePrinterUseCase(it, state.printerKitchenList)
                eventChannel.send(UIEvent.NavigateBack)
            }
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
        object NavigateBack : UIEvent()
        object RequestTesPrint : UIEvent()
    }
}