package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = ItemOnBoarding.TBL_NAME)
data class ItemOnBoarding(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = NAME)
    val name : String,
    @ColumnInfo(name = ITEMTYPE)
    val itemType : String,
    @ColumnInfo(name = ITEMGROUP)
    val itemGroup : String,
    @ColumnInfo(name = PRICE)
    val price : BigDecimal,
    @ColumnInfo(name = UNIT)
    val unit : String,
    @ColumnInfo(name = PICPATH)
    val picPath : String,
) {
    companion object {
        const val TBL_NAME = "dummy_item"

        const val ID = "id"
        const val NAME = "name"
        const val ITEMTYPE = "itemtype_code"
        const val ITEMGROUP = "itemgroup"
        const val PRICE = "price"
        const val UNIT = "unit"
        const val PICPATH = "picpath"
    }
}