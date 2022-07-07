package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*

@Entity(tableName = SaleAddOnDEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = SaleAddOnEntity::class,
            parentColumns = [SaleAddOnEntity.ID],
            childColumns = [SaleAddOnDEntity.SALEADDON_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = SaledEntity::class,
            parentColumns = [SaledEntity.ID],
            childColumns = [SaleAddOnDEntity.UP_SALED_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = SaledEntity::class,
            parentColumns = [SaledEntity.ID],
            childColumns = [SaleAddOnDEntity.SALED_ID],
            onDelete = ForeignKey.CASCADE
        ),
    ]
)
data class SaleAddOnDEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = SALEADDON_ID, index = true)
    var saleAddOnId: Int,
    @ColumnInfo(name = UP_SALED_ID, index = true)
    var upSaledId: Int,
    @ColumnInfo(name = SALED_ID, index = true)
    var saledId: Int,
) {
    companion object {
        const val TBL_NAME = "saleaddond"

        const val ID = "id"
        const val SALEADDON_ID = "saledaddon_id"
        const val UP_SALED_ID = "up_saled_id"
        const val SALED_ID = "saled_id"

    }
}