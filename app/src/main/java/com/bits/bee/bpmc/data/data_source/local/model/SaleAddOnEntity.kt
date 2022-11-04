package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*

@Entity(tableName = SaleAddOnEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = SaleEntity::class,
            parentColumns = [SaleEntity.ID],
            childColumns = [SaleAddOnEntity.SALE_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SaleAddOnEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int?,
    @ColumnInfo(name = SALE_ID)
    var saleId: Int,
) {
    companion object {
        const val TBL_NAME = "saleaddon"

        const val ID = "id"
        const val SALE_ID = "sale_id"

    }
}