package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Printer(
    var id : Int = 0,
    var printerName : String,
    var address : String,
    var tipe : Int,
    var size : String,
    var isReceipt : Boolean = true,
    var isKitchen : Boolean = true,
    var isReport : Boolean = true,
    var isChecker : Boolean = true,
): Parcelable