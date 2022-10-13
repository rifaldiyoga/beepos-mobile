package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import com.bits.bee.bpmc.domain.model.*

data class AddPrinterState(
    var namaPrinter: String="",
    var macAddress: String = "",
    var tipePrinter: String = "",
    var isReceipt : Boolean = true,
    var isKitchen : Boolean = false,
    var isReport : Boolean = false,
    var isChecker : Boolean = false,
    var mPrinter: Printer? = null,
    var listPrinter: List<Printer> = mutableListOf(),
    var mPrinterKitchen: PrinterKitchen? = null,
    var listPrinterKitchen: List<PrinterKitchen> = mutableListOf(),
    var listPrinterKitchenD: List<PrinterKitchenD> = mutableListOf(),
    var listKitchen: MutableList<Kitchen> = mutableListOf(),
    var listItemgrp: List<ItemGroup> = mutableListOf(),
    var kitchen: Kitchen? = null,
    var itmgrp: ItemGroup? = null,
    var data_kitchen: Boolean = false,
    var listhashMap : HashMap<Int, MutableList<Kitchen>>? = null
)
