package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.domain.usecase.printer.GetKategoriPrinterKitchenUseCase
import com.bits.bee.bpmc.domain.usecase.printer.GetListKitchenUseCase
import com.bits.bee.bpmc.domain.usecase.printer.PrinterInteractor
import com.bits.bee.bpmc.domain.usecase.printer.SavePrinterUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPrinterViewModel @Inject constructor(
    private val printerInteractor: PrinterInteractor,
    private val savePrinterUseCase: SavePrinterUseCase,
    private val getListKitchenUseCase: GetListKitchenUseCase,
    private val getKategoriPrinterKitchenUseCase: GetKategoriPrinterKitchenUseCase
): BaseViewModel<AddPrinterState, AddPrinterViewModel.UIEvent>() {

    private var data_kitchen = false
    private var listKitchen = mutableListOf<Kitchen>()

    init {
        state = AddPrinterState()
    }

    fun doSave() = viewModelScope.launch {
        savePrinterUseCase(state.mPrinter, state.listPrinterKitchen, state.listKitchen)
        eventChannel.send(UIEvent.RequestSimpan)
    }

    fun onClickPrinterKasir() = viewModelScope.launch {
        updateState(
            state.copy(
                mPrinter = state.mPrinter?.copy(isReceipt = !state.isReceipt)
            )
        )
    }

    fun onClickPrinterSetoran() = viewModelScope.launch {
        updateState(
            state.copy(
                mPrinter = state.mPrinter?.copy(isReport = !state.isReport)
            )
        )
    }

    private fun clearPrinterKitchen(id: Int) = viewModelScope.launch {
        printerInteractor.getByPrinterUseCase(id).collect {
            it.data?.let { data ->
                updateState(
                    state.copy(listPrinterKitchen = data)
                )
            }
        }
        val printerKitchenL = state.listPrinterKitchen
        for (printK in printerKitchenL!!){
            printK.id.let { deletePrinterKitD(it) }
            deletePrinterKit(printK)
        }
    }

    private fun deletePrinterKitD(id: Int) = viewModelScope.launch{
        printerInteractor.deletePrinterKitchenD(id)
    }

    private fun deletePrinterKit(printK: PrinterKitchen) = viewModelScope.launch{
        printerInteractor.deletePrinterKit(printK)
    }


    fun setPrinterKitchen(mPrinter: Printer?) = viewModelScope.launch {
        printerInteractor.getPrinterFromPrinterKitchen(mPrinter!!.id!!).collect {
            it.data?.let { data ->
                updateState(
                    state.copy(listPrinterKitchen = data)
                )
            }
        }

//        val printerKitchenList: List<PrinterKitchen>? = state.listPrinterKitchen
//        var listMap: HashMap<Int, MutableList<Kitchen>> = HashMap()
//        getListKitchenUseCase(state.listPrinterKitchen, state.data_kitchen).collect {
//            when(it.status){
//                Resource.Status.LOADING ->{
//
//                }
//                Resource.Status.SUCCESS ->{
//                    updateState(
//                        state.copy(listhashMap = it.data)
//                    )
//                }
//                Resource.Status.ERROR ->{
//
//                }
//            }
//        }
//        for((index, value) in state.listPrinterKitchen!!!!.withIndex()){
//            var printerKitchen: PrinterKitchen = state.listPrinterKitchen!!.get(index)
////            getDetailByPrinterKit(printerKitchen.id)
//
//            printerInteractor.getPrinterKitchenD(printerKitchen.id).collect {
//                it.data?.let { data ->
//                    updateState(
//                        state.copy(listPrinterKitchenD = data)
//                    )
//                }
//            }
//
//            var printerKitchenDlist: List<PrinterKitchenD>? = state.listPrinterKitchenD
//            var kitchenList: MutableList<Kitchen> = mutableListOf()
//            for (printerD in printerKitchenDlist!!){
////                setValuePrinterKitchenD(printerD)
//                printerInteractor.getKitchenId(printerD.id).collect {
//                    it.data?.let { data ->
//                        updateState(
//                            state.copy(kitchen = data)
//                        )
//                    }
//                }
//                if (data_kitchen){
//                    kitchenList.add(state.kitchen!!)
//                }else{
//                    var itmGrp: ItemGroup = state.itmgrp!!
//                    val kitchen = Kitchen(
//                        id = itmGrp.id,
//                        name = itmGrp.name,
//                    )
//                    kitchenList.add(kitchen)
//                    kitchenList.add(Kitchen(id=2, code=null, name="OTG", branchId=0, createdBy=0, createdAt=0, updatedBy=0, updatedAt=0, isUsed=false))
//                    kitchenList.add(Kitchen(id=5, code=null, name="Keyboard", branchId=0, createdBy=0, createdAt=0, updatedBy=0, updatedAt=0, isUsed=false))
//                }
//            }
////            listMap.put(index, kitchenList)
//            listKitchen.addAll(kitchenList)
//            updateState(
//                state.copy(listKitchen = listKitchen)
//            )
//        }
//        sectionKitchenAdapter.initList(state.listPrinterKitchen!!, listKitchen)
    }

    fun onClickShowPrinter() = viewModelScope.launch{
        eventChannel.send(UIEvent.RequestTipePrinter)
    }

    sealed class UIEvent{
        object RequestTipePrinter : UIEvent()
        object RequestSimpan : UIEvent()
    }
}