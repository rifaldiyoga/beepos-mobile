package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = ItemOnBoarding.TBL_NAME)
data class ItemOnBoarding(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = NAME)
    var name : String,
    @ColumnInfo(name = ITEMTYPE)
    var itemType : String,
    @ColumnInfo(name = ITEMGROUP)
    var itemGroup : String,
    @ColumnInfo(name = PRICE)
    var price : BigDecimal,
    @ColumnInfo(name = UNIT)
    var unit : String,
    @ColumnInfo(name = PICPATH)
    var picPath : String,
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