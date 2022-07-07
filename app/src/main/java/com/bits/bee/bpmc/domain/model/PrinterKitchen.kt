package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class PrinterKitchen(
    var id : Int = 0,
    var kitchenName : String,
    var printerId: Int = 0,
): Parcelable