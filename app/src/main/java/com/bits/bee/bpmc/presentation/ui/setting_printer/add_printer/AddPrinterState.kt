package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import com.bits.bee.bpmc.data.data_source.local.model.Printer

data class AddPrinterState(
    var namaPrinter: String="",
    var macAddress: String = "",
    var tipePrinter: String = "",
    var usePrinterKasir: Boolean = false,
    var usePrinterSetoran: Boolean = false,
    var usePrinterKitchen: Boolean = false,
    var mPrinter: Printer? = null
)
