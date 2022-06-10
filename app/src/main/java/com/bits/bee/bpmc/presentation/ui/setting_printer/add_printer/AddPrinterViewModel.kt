package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.local.model.*
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.usecase.printer.PrinterInteractor
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen.SectionKitchenAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPrinterViewModel @Inject constructor(
    printerInteractor: PrinterInteractor
): BaseViewModel<AddPrinterState, AddPrinterViewModel.UIEvent>() {
    private lateinit var sectionKitchenAdapter: SectionKitchenAdapter
    private var data_kitchen = false
    private var _idPrinter: Int = 0
    private var _idPrinterKitchen: Int = 0
    private var _idPrinterKitchenD: Int = 0
    private var _addresPrinter: String = ""
    private var mPrinterInteractor: PrinterInteractor
//    private lateinit var mListPrinterKitchen: List<PrinterKitchen>
//    private lateinit var mListPrinterKitchenD: List<PrinterKitchenD>
//    private lateinit var mKitchen: Kitchen
//    private lateinit var mItmgrp: ItemGroup
    private var printerKitchenList: List<PrinterKitchen> = mutableListOf()
    private var mListMap: HashMap<Int, MutableList<Kitchen>> = HashMap()

    init {
        state = AddPrinterState()
        mPrinterInteractor = printerInteractor
    }

    fun setSectionKitAdapter(sectionKitchenAdapter: SectionKitchenAdapter){
        this.sectionKitchenAdapter = sectionKitchenAdapter
    }

    fun setDataKitchen(boolean: Boolean){
        data_kitchen = boolean
    }

    fun setValuePrinter(printer: Printer?){
        _idPrinter = printer!!.id
    }

   private fun setValuePrinterKitchen(printerKitchen: PrinterKitchen){
        _idPrinterKitchen = printerKitchen.id
    }

   private fun setValuePrinterKitchenD(printerKitchenD: PrinterKitchenD){
        _idPrinterKitchenD = printerKitchenD.kitchenId
    }

    fun valueIsNewPrinter(printer: Printer?){
        _addresPrinter = printer!!.address
        _idPrinter = printer.id
    }

    private fun addPrinter(printer: Printer?) = viewModelScope.launch {
        mPrinterInteractor.addUpdatePrinter(printer)
    }

    private fun addPrinterKitchen(printerKitchen: PrinterKitchen) = viewModelScope.launch {
        mPrinterInteractor.addUpdatePrinterK(printerKitchen)
    }

    private fun addPrinterKitchenD(printerKitchenD: PrinterKitchenD) = viewModelScope.launch {
        mPrinterInteractor.AddUpdatePrinterKitchenD(printerKitchenD)
    }

    private fun updatePrinter(printer: Printer?) = viewModelScope.launch{
        mPrinterInteractor.addUpdatePrinter.update(printer)
    }

    private fun deletePrinterKitD(id: Int) = viewModelScope.launch{
        mPrinterInteractor.deletePrinterKitchenD(id)
    }

    private fun deletePrinterKit(printK: PrinterKitchen) = viewModelScope.launch{
        mPrinterInteractor.deletePrinterKit(printK)
    }

    private fun clearPrinterKitchen() {
        val printerKitchenL = state.listPrinterKitchen
        for (printK in printerKitchenL!!){
            deletePrinterKitD(printK.id)
            deletePrinterKit(printK)
        }
    }

//    fun setPrinterKitchenList(list: List<PrinterKitchen>){
//        this.mListPrinterKitchen = list
//    }
//
//    fun setPrinterKitchenDList(list: List<PrinterKitchenD>){
//        this.mListPrinterKitchenD = list
//    }
//
//    fun setKitchen(kitchen: Kitchen){
//        this.mKitchen = kitchen
//    }
//
//    fun setItemgrp(itemGroup: ItemGroup){
//        this.mItmgrp = itemGroup
//    }



    val getPrinterFromPrinterKitchen = printerInteractor.getPrinterFromPrinterKitchen(_idPrinter)

    val getPrinterKitchenFromDetail = printerInteractor.getPrinterKitchenFromDetail(_idPrinterKitchen)

    val getKitchenId = printerInteractor.getKitchenId(_idPrinterKitchenD)

    val getItmgrpId = printerInteractor.itemGrpId(5)

    val printerAddressList = printerInteractor.getAddressPrinterUseCase(_addresPrinter)

    val getLastIdVal = printerInteractor.getLastId()

    val getLastIdPrinterKit = printerInteractor.getLastIdPrinterKitchen()

    val getByPrinter = printerInteractor.getByPrinterUseCase(_idPrinter)


    fun setPrinterKitchen(){
        val printerKitchenList: List<PrinterKitchen>? = state.listPrinterKitchen
        var listMap: HashMap<Int, MutableList<Kitchen>> = HashMap()
        for((index, value) in printerKitchenList!!.withIndex()){
            var printerKitchen: PrinterKitchen = printerKitchenList.get(index)
            setValuePrinterKitchen(printerKitchen)
            var printerKitchenDlist: List<PrinterKitchenD>? = state.listPrinterKitchenD
            var kitchenList: MutableList<Kitchen> = mutableListOf()
            for (printerD in printerKitchenDlist!!){
                setValuePrinterKitchenD(printerD)
                if (data_kitchen){
                    kitchenList.add(state.kititchen!!)
                }else{
                    var itmGrp: ItemGroup = state.itmgrp!!
                    val kitchen = Kitchen(
                        id = itmGrp.id,
                        code = "",
                        name = itmGrp.name,
                        branchId = -1,
                        createdBy = -1,
                        createdAt = -1,
                        updatedBy = -1,
                        updatedAt = -1,
                        isUsed = false
                    )
                    kitchenList.add(kitchen)
                }
            }
            listMap.put(index, kitchenList)
        }
        sectionKitchenAdapter.initList(printerKitchenList, listMap)
    }

    fun onClickShowPrinter() = viewModelScope.launch{
        eventChannel.send(UIEvent.RequestTipePrinter)
    }

    fun update(state: AddPrinterState){
        _state.update {
            state
        }
    }

    fun getDataList(){
        printerKitchenList = sectionKitchenAdapter.getPrinterKitchenList()
        mListMap = sectionKitchenAdapter.getPrinterKitchenListmap()
    }

    fun save(printer: Printer?, printerKitchenList: List<PrinterKitchen>,
                     mListMap: HashMap<Int, MutableList<Kitchen>>) = viewModelScope.launch{
        val listPrinter: List<Printer> = state.listPrinter!!
        if (listPrinter.isEmpty()){
            addPrinter(printer)

            for ((index, value) in printerKitchenList.withIndex()){
                var printerKitchen: PrinterKitchen = printerKitchenList.get(index)
                val idPrinter = state.mPrinter!!.id
                printerKitchen.copy(kitchenName = printerKitchen.kitchenName, printerId = idPrinter)
//                printerKitchen = PrinterKitchen(-1, printerKitchen.kitchenName, idPrinter)
                addPrinterKitchen(printerKitchen)
                val idPrinterKit = state.mPrinterKitchen!!.id
                var kitchenList = mListMap.get(index)

                for (kitchen in kitchenList!!){
                    var printerKitchenD = PrinterKitchenD(0, idPrinterKit, kitchen.id)
                    addPrinterKitchenD(printerKitchenD)
                }
            }
        }else{
            printer?.copy(id = listPrinter.get(0).id)
            updatePrinter(printer)
//            clearPrinterKitchen()

            for ((index, value) in printerKitchenList.withIndex()){
                var printerKitchen = printerKitchenList.get(index)
                val id = printer!!.id
                printerKitchen.copy(printerId = id, kitchenName = printerKitchen.kitchenName)
                addPrinterKitchen(printerKitchen)
                val idPrinterKit = state.mPrinterKitchen!!.id

                val kitchenList = mListMap.get(index)
                for (kitchen in kitchenList!!){
                    val printerKitchenD = PrinterKitchenD(0, idPrinterKit, kitchen.id)
                    addPrinterKitchenD(printerKitchenD)
                }
            }
        }
        eventChannel.send(UIEvent.RequestSimpan)
    }

    sealed class UIEvent{
        object RequestTipePrinter : UIEvent()
        object RequestSimpan : UIEvent()
    }
}