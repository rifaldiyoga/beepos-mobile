package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*

@Entity(tableName = PrinterKitchenEntity.TBL_NAME,
    foreignKeys = [
    ]
)
data class PrinterKitchenEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int?,
    @ColumnInfo(name = KITCHEN_NAME)
    var kitchenName : String,
    @ColumnInfo(name = PRINTER_ID, index = true)
    var printerId: Int = 0,
) {
    companion object {
        const val TBL_NAME = "printer_kitchen"

        const val ID = "id"
        const val KITCHEN_NAME = "kitchen_name"
        const val PRINTER_ID = "printer_id"

    }
}