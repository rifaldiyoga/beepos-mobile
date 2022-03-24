package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Printer.TBL_NAME)
data class Printer(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = PRINTERNAME)
    val printerName : String,
    @ColumnInfo(name = ADDRESS)
    val address : String,
    @ColumnInfo(name = TIPE)
    val tipe : Int,
    @ColumnInfo(name = SIZE)
    val size : String,
    @ColumnInfo(name = IS_RECEIPT)
    val isReceipt : Boolean = true,
    @ColumnInfo(name = IS_KITCHEN)
    val isKitchen : Boolean = true,
    @ColumnInfo(name = IS_REPORT)
    val isReport : Boolean = true,
    @ColumnInfo(name = IS_CHECKER)
    val isChecker : Boolean = true,
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