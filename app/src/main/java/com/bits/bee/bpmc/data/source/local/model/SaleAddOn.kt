package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*

@Entity(tableName = SaleAddOn.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Sale::class,
            parentColumns = [Sale.ID],
            childColumns = [SaleAddOn.SALE_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SaleAddOn(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = SALE_ID)
    val saleId: Int,
) {
    companion object {
        const val TBL_NAME = "saleaddon"

        const val ID = "id"
        const val SALE_ID = "sale_id"

    }
}