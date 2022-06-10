package com.bits.bee.bpmc.presentation.ui.setting_printer

import com.bits.bee.bpmc.data.data_source.local.model.Printer

data class SettingPrinterState(
    var mlistPrinter: List<Printer>? = null,
    var mPrinter: Printer? = null
) {

}