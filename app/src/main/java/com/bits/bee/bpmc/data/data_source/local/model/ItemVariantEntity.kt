package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = ItemVariantEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = VariantEntity::class,
            parentColumns = [VariantEntity.ID],
            childColumns = [ItemVariantEntity.VARIANT_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = ItemEntity::class,
            parentColumns = [ItemEntity.ID],
            childColumns = [ItemVariantEntity.ITEM_ID],
            onDelete = CASCADE
        )
    ]
)
data class ItemVariantEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = VARIANT_ID, index = true)
    var variantId: Int,
    @ColumnInfo(name = ITEM_ID, index = true)
    var itemId : Int,
) {
    companion object {
        const val TBL_NAME = "item_variant"

        const val ID = "id"
        const val VARIANT_ID = "variant_id"
        const val ITEM_ID = "item_id"

    }
}