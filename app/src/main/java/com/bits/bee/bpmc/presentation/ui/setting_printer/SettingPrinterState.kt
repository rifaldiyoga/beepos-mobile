package com.bits.bee.bpmc.presentation.ui.setting_printer

import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity

data class SettingPrinterState(
    var mlistPrinter: List<PrinterEntity>? = null,
    var mPrinter: PrinterEntity? = null
) {

}