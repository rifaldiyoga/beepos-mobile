package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = ItemKitchen.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Item::class,
            parentColumns = [Item.ID],
            childColumns = [ItemKitchen.ITEM_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = [Item.ID],
            childColumns = [ItemKitchen.ITEM_ID],
            onDelete = CASCADE
        )
    ]
)
data class ItemKitchen(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = ITEM_ID, index = true)
    val itemId: Int,
    @ColumnInfo(name = KITCHEN_ID, index = true)
    val kitchenId: Int,
    @ColumnInfo(name = CREATED_BY)
    val createdBy : Int,
    @ColumnInfo(name = CREATED_AT)
    val createdAt : Long,
    @ColumnInfo(name = UPDATED_BY)
    val updatedBy : Int,
    @ColumnInfo(name = UPDATED_AT)
    val updatedAt : Long,
) {
    companion object {
        const val TBL_NAME = "item_kitchen"
        const val ID = "id"
        const val ITEM_ID = "item_id"
        const val KITCHEN_ID = "kitchen_id"
        const val CREATED_AT = "created_at"
        const val CREATED_BY = "created_by"
        const val UPDATED_AT = "updated_at"
        const val UPDATED_BY = "updated_by"
    }
}