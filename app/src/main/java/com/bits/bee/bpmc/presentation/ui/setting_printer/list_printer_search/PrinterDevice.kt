package com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 10/10/22
 */
@Parcelize
data class PrinterDevice(
    val nama : String,
    val address : String
) : Parcelable