package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.usecase.printer.GetKategoriPrinterKitchenUseCase
import com.bits.bee.bpmc.domain.usecase.printer.GetListKitchenUseCase
import com.bits.bee.bpmc.domain.usecase.printer.PrinterInteractor
import com.bits.bee.bpmc.domain.usecase.printer.SavePrinterUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen.SectionKitchenAdapter
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPrinterViewModel @Inject constructor(
    private val printerInteractor: PrinterInteractor,
    private val savePrinterUseCase: SavePrinterUseCase,
    private val getListKitchenUseCase: GetListKitchenUseCase,
    private val getKategoriPrinterKitchenUseCase: GetKategoriPrinterKitchenUseCase
): BaseViewModel<AddPrinterState, AddPrinterViewModel.UIEvent>() {
    private lateinit var sectionKitchenAdapter: SectionKitchenAdapter
    private var data_kitchen = false

    private var listKitchen = mutableListOf<Kitchen>()

    init {
        state = AddPrinterState()
    }

//    var kitchenList : Flow<Resource<MutableList<Kitchen>>> = getKategoriPrinterKitchenUseCase(state.data_kitchen)
    private fun deletePrinterKitD(id: Int) = viewModelScope.launch{
        printerInteractor.deletePrinterKitchenD(id)
    }

    private fun deletePrinterKit(printK: PrinterKitchen) = viewModelScope.launch{
        printerInteractor.deletePrinterKit(printK)
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
            printK.id?.let { deletePrinterKitD(it) }
            deletePrinterKit(printK)
        }
    }

//    val loadKitchen = printerInteractor.loadKitchen()
//
//    val getItemgrpKitchen = printerInteractor.getItemgrpKitchen()

    fun setPrinterKitchen(mPrinter: Printer?) = viewModelScope.launch {
        printerInteractor.getPrinterFromPrinterKitchen(mPrinter!!.id).collect {
            it.data?.let { data ->
                updateState(
                    state.copy(listPrinterKitchen = data)
                )
            }
        }

//        val printerKitchenList: List<PrinterKitchen>? = state.listPrinterKitchen
//        var listMap: HashMap<Int, MutableList<Kitchen>> = HashMap()
        getListKitchenUseCase(state.listPrinterKitchen, state.data_kitchen).collect {
            when(it.status){
                Resource.Status.LOADING ->{
                    val str=""
                }
                Resource.Status.SUCCESS ->{
                    updateState(
                        state.copy(listhashMap = it.data)
                    )
                }
                Resource.Status.ERROR ->{
                    val str=""
                }
            }
        }
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

    fun save(printer: Printer?, printerKitchenList: List<PrinterKitchen>,
             mListKitchen: MutableList<Kitchen>) = viewModelScope.launch{
        savePrinterUseCase(printer, printerKitchenList, mListKitchen)
//        if (listPrinter.isEmpty()){
//
////            addPrinter(printer)
//            printerInteractor.addUpdatePrinter(printer)
//
//
//            for ((index, value) in printerKitchenList.withIndex()){
//                printerInteractor.getLastId().collect {
//                    it.data?.let { data ->
//                        updateState(
//                            state.copy(mPrinter = data)
//                        )
//                    }
//                }
//                var printerKitchen = printerKitchenList.get(index)
//                printerKitchen.kitchenName = printerKitchen.kitchenName
//                printerKitchen.printerId = state.mPrinter!!.id
//
//                printerInteractor.addUpdatePrinterK(printerKitchen)
//
//                printerInteractor.getLastIdPrinterKitchen().collect {
//                    it.data?.let { data ->
//                        updateState(
//                            state.copy(mPrinterKitchen = data)
//                        )
//                    }
//                }
//
//                for (kit in mListKitchen){
//                    var printerKitchenD = PrinterKitchenD(printerKitchenId = state.mPrinterKitchen!!.id, kitchenId = kit.id)
////                        addPrinterKitchenD(printerKitchenD)
//                    printerInteractor.AddUpdatePrinterKitchenD(printerKitchenD)
//                }
////                for (kitchen in mList.get(index)){
////                    var printerKitchenD = PrinterKitchenD(printerKitchenId = state.mPrinterKitchen!!.id, kitchenId = kitchen.id)
////                    addPrinterKitchenD(printerKitchenD)
////                }
//            }
//        }else{
//            printer?.id = listPrinter.get(0).id
////            printer?.copy(id = listPrinter.get(0).id)
//            updatePrinter(printer)
//            clearPrinterKitchen(printer!!.id)
//
//            for ((index, value) in printerKitchenList.withIndex()){
//                var printerKitchen = printerKitchenList.get(index)
//                val id = printer!!.id
//                printerKitchen.copy(printerId = id, kitchenName = printerKitchen.kitchenName)
//                addPrinterKitchen(printerKitchen)
//                val idPrinterKit = state.mPrinterKitchen!!.id
//
//                val kitchenList = mListMap.get(index)
//                for (kitchen in kitchenList!!){
//                    val printerKitchenD = PrinterKitchenD(printerKitchenId = idPrinterKit, kitchenId = kitchen.id)
//                    addPrinterKitchenD(printerKitchenD)
//                }
//            }
//        }
        eventChannel.send(UIEvent.RequestSimpan)
    }

    fun loadKategoriPrinterKit() = viewModelScope.launch {
//        var mutable = mutableListOf<Kitchen>()
        getKategoriPrinterKitchenUseCase(state.data_kitchen).collect {
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    updateState(
                        state.copy(
                            listKitchen = it.data
                        )
                    )
                }
                Resource.Status.ERROR -> {

                }
            }
        }

//        if (data_kitchen){
//            mutable = state.listKitchen!!
//        }else{
//            val itemgrpList = state.listItemgrp
//            for (itmgrp in itemgrpList!!){
//                var kitchen = Kitchen(id = itmgrp.id, name = itmgrp.name)
//                mutable.add(kitchen)
//            }
//        }
//        sectionKitchenAdapter.setKitchenList(listKitchen)
    }

    sealed class UIEvent{
        object RequestTipePrinter : UIEvent()
        object RequestSimpan : UIEvent()
    }
}