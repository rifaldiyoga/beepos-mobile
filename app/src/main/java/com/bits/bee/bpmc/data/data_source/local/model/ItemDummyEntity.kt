package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = ItemDummyEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = ItemGroupEntity::class,
            parentColumns = [ItemGroupEntity.ID],
            childColumns = [ItemDummyEntity.ITEMGROUP_ID],
        )
    ]
)
data class ItemDummyEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= ID)
    var id : Int?,
    @ColumnInfo(name= NAME)
    var name: String,
    @ColumnInfo(name= ITEMTYPE)
    var itemTypeCode: String,
    @ColumnInfo(name= ITEMGROUP_ID)
    var itemGroupId : Int = -1,
    @ColumnInfo(name= PRICE)
    var price : String,
    @ColumnInfo(name= PID)
    var pid: String,
    @ColumnInfo(name= PICPATH)
    var picPath : String,
) {
    companion object {
        const val TBL_NAME = "item_dummy"

        const val ID = "id"
        const val NAME = "name"
        const val ITEMTYPE = "itemtype_code"
        const val ITEMGROUP_ID = "itemgroup_id"
        const val PRICE = "price"
        const val UNIT = "unit"
        const val PID = "pid"
        const val PICPATH = "picpath"

    }
}