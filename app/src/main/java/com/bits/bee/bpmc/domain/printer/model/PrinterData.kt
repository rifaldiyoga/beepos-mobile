package com.bits.bee.bpmc.domain.printer.model

import com.bits.bee.bpmc.domain.model.Printer


data class PrinterData (
    var printer: Printer? = null,
    var toPrint: String? = null,
    var fontType: ByteArray? = null,
    var alignMode: ByteArray? = null
)