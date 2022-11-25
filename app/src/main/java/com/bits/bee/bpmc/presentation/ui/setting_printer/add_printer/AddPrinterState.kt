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
    var printerKitchenList: List<PrinterKitchen> = mutableListOf(),
)
