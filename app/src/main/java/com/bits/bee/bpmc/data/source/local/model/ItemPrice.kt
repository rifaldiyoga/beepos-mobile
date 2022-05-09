package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = ItemPrice.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Item::class,
            parentColumns = [Item.ID],
            childColumns = [ItemPrice.ITEM_ID]
        ),
        ForeignKey(
            entity = PriceLvlEntity::class,
            parentColumns = [PriceLvlEntity.ID],
            childColumns = [ItemPrice.PRICELVL_ID]
        )
    ]
)
data class ItemPrice(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = ITEM_ID, index = true)
    var itemId: Int,
    @ColumnInfo(name = PRICELVL_ID, index = true)
    var pricelvlId: Int,
    @ColumnInfo(name = PRICE1)
    var price: Int,
) {
    companion object {
        const val TBL_NAME = "item_price"

        const val ID = "id"
        const val ITEM_ID = "itemid"
        const val PRICE1 = "price1"
        const val PRICELVL_ID = "pricelvl_id"
        const val LASTSYNC = "last_sync"

    }
}