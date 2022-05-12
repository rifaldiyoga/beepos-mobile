package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = ItemKitchen.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = ItemEntitiy::class,
            parentColumns = [ItemEntitiy.ID],
            childColumns = [ItemKitchen.ITEM_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = ItemEntitiy::class,
            parentColumns = [ItemEntitiy.ID],
            childColumns = [ItemKitchen.ITEM_ID],
            onDelete = CASCADE
        )
    ]
)
data class ItemKitchen(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = ITEM_ID, index = true)
    var itemId: Int,
    @ColumnInfo(name = KITCHEN_ID, index = true)
    var kitchenId: Int,
    @ColumnInfo(name = CREATED_BY)
    var createdBy : Int,
    @ColumnInfo(name = CREATED_AT)
    var createdAt : Long,
    @ColumnInfo(name = UPDATED_BY)
    var updatedBy : Int,
    @ColumnInfo(name = UPDATED_AT)
    var updatedAt : Long,
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