package com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen

import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by aldi on 14/11/22
 */
data class KitchenState(
    val printerKitchen: PrinterKitchen? = null,
    val kitchenList: MutableList<Kitchen> = mutableListOf()
)