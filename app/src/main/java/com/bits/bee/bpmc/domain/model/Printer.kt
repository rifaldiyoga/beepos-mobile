package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Printer(
    var id : Int? = null,
    var printerName : String = "",
    var address : String = "",
    var tipe : Int? = null,
    var size : String = "58 mm",
    var isReceipt : Boolean = true,
    var isKitchen : Boolean = false,
    var isReport : Boolean = true,
    var isChecker : Boolean = false,
): Parcelable