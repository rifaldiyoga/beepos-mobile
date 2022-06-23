package com.bits.bee.bpmc.domain.model

import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenDEntity

data class PrinterKitchenD(
    var id : Int = 0,
    var printerKitchenId: Int,
    var kitchenId: Int
)