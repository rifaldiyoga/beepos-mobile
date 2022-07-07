package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import com.bits.bee.bpmc.data.data_source.local.model.KitchenEntity
import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenEntity
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenDEntity
import com.bits.bee.bpmc.domain.model.*

data class AddPrinterState(
    var namaPrinter: String="",
    var macAddress: String = "",
    var tipePrinter: String = "",
    var usePrinterKasir: Boolean = false,
    var usePrinterSetoran: Boolean = false,
    var usePrinterKitchen: Boolean = false,
    var mPrinter: Printer? = null,
    var listPrinter: List<Printer>? = null,
    var mPrinterKitchen: PrinterKitchen? = null,
    var listPrinterKitchen: List<PrinterKitchen>? = null,
    var listPrinterKitchenD: List<PrinterKitchenD>? = null,
    var listKitchen: MutableList<Kitchen>? = null,
    var listItemgrp: List<ItemGroup>? = null,
    var kitchen: Kitchen? = null,
    var itmgrp: ItemGroup? = null,
    var data_kitchen: Boolean = false,
    var listhashMap : HashMap<Int, MutableList<Kitchen>>?
    = null
)
