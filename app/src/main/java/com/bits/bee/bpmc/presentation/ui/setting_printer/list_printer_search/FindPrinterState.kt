package com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search

data class FindPrinterState(
    val deviceList : List<PrinterDevice> = mutableListOf(),
)