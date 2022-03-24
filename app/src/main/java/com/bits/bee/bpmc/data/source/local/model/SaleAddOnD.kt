package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*

@Entity(tableName = SaleAddOnD.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = SaleAddOn::class,
            parentColumns = [SaleAddOn.ID],
            childColumns = [SaleAddOnD.SALEADDON_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Saled::class,
            parentColumns = [Saled.ID],
            childColumns = [SaleAddOnD.UP_SALED_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Saled::class,
            parentColumns = [Saled.ID],
            childColumns = [SaleAddOnD.SALED_ID],
            onDelete = ForeignKey.CASCADE
        ),
    ]
)
data class SaleAddOnD(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = SALEADDON_ID, index = true)
    val saleAddOnId: Int,
    @ColumnInfo(name = UP_SALED_ID, index = true)
    val upSaledId: Int,
    @ColumnInfo(name = SALED_ID, index = true)
    val saledId: Int,
) {
    companion object {
        const val TBL_NAME = "saleaddond"

        const val ID = "id"
        const val SALEADDON_ID = "saledaddon_id"
        const val UP_SALED_ID = "up_saled_id"
        const val SALED_ID = "saled_id"

    }
}