package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = PrinterEntity.TBL_NAME)
data class PrinterEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int?,
    @ColumnInfo(name = PRINTERNAME)
    var printerName : String,
    @ColumnInfo(name = ADDRESS)
    var address : String,
    @ColumnInfo(name = TIPE)
    var tipe : Int,
    @ColumnInfo(name = SIZE)
    var size : String,
    @ColumnInfo(name = IS_RECEIPT)
    var isReceipt : Boolean = true,
    @ColumnInfo(name = IS_KITCHEN)
    var isKitchen : Boolean = true,
    @ColumnInfo(name = IS_REPORT)
    var isReport : Boolean = true,
    @ColumnInfo(name = IS_CHECKER)
    var isChecker : Boolean = true,
) {
    companion object {
        const val TBL_NAME = "printer"

        const val ID = "id"
        const val PRINTERNAME = "printername"
        const val ADDRESS = "address"
        const val TIPE = "tipe"
        const val SIZE = "size"
        const val IS_RECEIPT = "is_receipt"
        const val IS_KITCHEN = "is_kitchen"
        const val IS_REPORT = "is_report"
        const val IS_CHECKER = "is_checker"
        const val KITCHENNAME = "kitchen"

    }
}