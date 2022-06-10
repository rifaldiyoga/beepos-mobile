package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import com.bits.bee.bpmc.data.data_source.local.model.Kitchen
import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchen
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenD
import com.bits.bee.bpmc.domain.model.ItemGroup

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
    var kititchen: Kitchen? = null,
    var itmgrp: ItemGroup? = null,
)
