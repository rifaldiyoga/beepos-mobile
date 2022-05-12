package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*

@Entity(tableName = ItemAddOn.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = ItemEntitiy::class,
            parentColumns = [ItemEntitiy.ID],
            childColumns = [ItemAddOn.ITEM_ID]
        ),
        ForeignKey(
            entity = AddOn::class,
            parentColumns = [AddOn.ID],
            childColumns = [ItemAddOn.ADDON_ID]
        )
    ]
)
data class ItemAddOn(
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