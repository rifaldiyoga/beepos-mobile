package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*

@Entity(tableName = PrinterKitchenD.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = PrinterKitchen::class,
            parentColumns = [PrinterKitchen.ID],
            childColumns = [PrinterKitchenD.PRINTER_KITCHEN_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Kitchen::class,
            parentColumns = [Kitchen.ID],
            childColumns = [PrinterKitchenD.KITCHEN_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PrinterKitchenD(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = PRINTER_KITCHEN_ID, index = true)
    var printerKitchenId: Int,
    @ColumnInfo(name = KITCHEN_ID, index = true)
    var kitchenId: Int,
) {
    companion object {
        const val TBL_NAME = "printer_kitchend"

        const val ID = "id"
        const val PRINTER_KITCHEN_ID = "printer_kitchen_id"
        const val KITCHEN_ID = "kitchen_id"

    }
}