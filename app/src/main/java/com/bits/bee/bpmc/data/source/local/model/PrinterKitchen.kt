package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*

@Entity(tableName = PrinterKitchen.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Printer::class,
            parentColumns = [Printer.ID],
            childColumns = [PrinterKitchen.PRINTER_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PrinterKitchen(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = KITCHEN_NAME)
    var kitchenName : String,
    @ColumnInfo(name = PRINTER_ID, index = true)
    var printerId: Int,
) {
    companion object {
        const val TBL_NAME = "printer_kitchen"

        const val ID = "id"
        const val KITCHEN_NAME = "kitchen_name"
        const val PRINTER_ID = "printer_id"

    }
}