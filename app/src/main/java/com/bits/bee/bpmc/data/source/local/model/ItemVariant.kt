package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = ItemVariant.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Variant::class,
            parentColumns = [Variant.ID],
            childColumns = [ItemVariant.VARIANT_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = [Item.ID],
            childColumns = [ItemVariant.ITEM_ID],
            onDelete = CASCADE
        )
    ]
)
data class ItemVariant(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = VARIANT_ID, index = true)
    var variant: Int,
    @ColumnInfo(name = ITEM_ID, index = true)
    var item : Int,
) {
    companion object {
        const val TBL_NAME = "item_variant"

        const val ID = "id"
        const val VARIANT_ID = "variant_id"
        const val ITEM_ID = "item"

    }
}