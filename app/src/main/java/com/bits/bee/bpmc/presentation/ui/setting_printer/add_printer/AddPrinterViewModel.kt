package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.local.model.Kitchen
import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchen
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenD
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.usecase.printer.PrinterInteractor
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen.SectionKitchenAdapter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddPrinterViewModel @Inject constructor(
    printerInteractor: PrinterInteractor
): BaseViewModel<AddPrinterState, AddPrinterViewModel.UIEvent>() {
    private lateinit var sectionKitchenAdapter: SectionKitchenAdapter

    private var data_kitchen = false
    private var _idPrinter: Int = 0
    private var _idPrinterKitchen: Int = 0
    private var _idPrinterKitchenD: Int = 0

    init {
        state = AddPrinterState()
    }

    fun setDataKitchen(boolean: Boolean){
        data_kitchen = boolean
    }

    fun setValuePrinter(printer: Printer?){
        _idPrinter = printer!!?.id!!
    }

    fun setValuePrinterKitchen(printerKitchen: PrinterKitchen){
        _idPrinterKitchen = printerKitchen.id
    }

    fun setValuePrinterKitchenD(printerKitchenD: PrinterKitchenD){
        _idPrinterKitchenD = printerKitchenD.kitchenId
    }

    val printerAddressList = printerInteractor.getAddressPrinterUseCase

    val getPrinterFromPrinterKitchen = printerInteractor.getPrinterFromPrinterKitchen(_idPrinter)

    val getPrinterKitchenFromDetail = printerInteractor.getPrinterKitchenFromDetail(_idPrinterKitchen)

    val getKitchenId = printerInteractor.getKitchenId(_idPrinterKitchenD)

    val getItmgrpId = printerInteractor.itemGrpId(_idPrinterKitchenD)

    fun setPrinterKitchen(){
        val printerKitchenList: List<PrinterKitchen> = getPrinterFromPrinterKitchen
        var listMap: HashMap<Int, MutableList<Kitchen>> = HashMap()
        for((index, value) in printerKitchenList.withIndex()){
            var printerKitchen: PrinterKitchen = printerKitchenList.get(index)
            setValuePrinterKitchen(printerKitchen)
            var printerKitchenDlist: List<PrinterKitchenD> = getPrinterKitchenFromDetail
            var kitchenList: MutableList<Kitchen> = mutableListOf()
            for (printerD in printerKitchenDlist){
                setValuePrinterKitchenD(printerD)
                if (data_kitchen){
                    kitchenList.add(getKitchenId)
                }else{
                    var itmGrp: ItemGroup = getItmgrpId
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

    sealed class UIEvent{
        object RequestTipePrinter : UIEvent()
        object RequestSimpan : UIEvent()
    }
}