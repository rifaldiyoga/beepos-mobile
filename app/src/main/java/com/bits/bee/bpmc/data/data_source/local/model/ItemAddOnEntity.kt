package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*

@Entity(tableName = ItemAddOnEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = ItemEntity::class,
            parentColumns = [ItemEntity.ID],
            childColumns = [ItemAddOnEntity.ITEM_ID]
        ),
        ForeignKey(
            entity = AddOnEntity::class,
            parentColumns = [AddOnEntity.ID],
            childColumns = [ItemAddOnEntity.ADDON_ID]
        )
    ]
)
data class ItemAddOnEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = ADDON_ID, index = true)
    var addOnId: Int,
    @ColumnInfo(name = CODE)
    var code: String,
    @ColumnInfo(name = ITEM_ID, index = true)
    var itemId : Int,
) {
    companion object {
        const val TBL_NAME = "itemaddon"

        const val ID = "id"
        const val CODE = "code"
        const val ITEM_ID = "item_id"
        const val ADDON_ID = "addon"


    }
}