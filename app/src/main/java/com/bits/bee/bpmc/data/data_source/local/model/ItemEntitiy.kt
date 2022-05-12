package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import java.math.BigDecimal

@Entity(tableName = ItemEntitiy.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = ItemGroupEntity::class,
            parentColumns = [ItemGroupEntity.ID],
            childColumns = [ItemEntitiy.ITGRP_ID],
            onDelete = CASCADE
        )
    ]
)
data class ItemEntitiy(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = TITLE)
    var title: String,
    @ColumnInfo(name = PICPATH)
    var picPath: String,
    @ColumnInfo(name = PRICE)
    var price : BigDecimal,
    @ColumnInfo(name = TAX)
    var tax : String,
    @ColumnInfo(name = ITGRP_ID, index = true)
    var itgrpId: Int,
    @ColumnInfo(name = BUCKET)
    var bucket : Long,
    @ColumnInfo(name = OBJKEY)
    var objKey : String,
    @ColumnInfo(name = TEMPURL)
    var tempUrl : String,
    @ColumnInfo(name = SALEUNIT)
    var saleUnit : String,
    @ColumnInfo(name = ACTIVE)
    var isActive : Boolean,
    @ColumnInfo(name = ITEMQTY)
    var itemQty : Int = 0,
    @ColumnInfo(name = ISPOS)
    var isPos : Boolean,
    @ColumnInfo(name = TYPE)
    var type : String,
    @ColumnInfo(name = FAVORIT)
    var isFavorit : Boolean,
    @ColumnInfo(name = AVAILABLE)
    var isAvailable : Boolean = true,
    @ColumnInfo(name = VARIANT)
    var isVariant : Boolean = false,
    @ColumnInfo(name = USEPID)
    var usePid : Boolean = false,
    @ColumnInfo(name = VCODE)
    var vCode : String,
    @ColumnInfo(name = VCOLOR)
    var vColor : String,
) {
    companion object {
        const val TBL_NAME = "item"

        const val ID = "id"
        const val CODE = "code"
        const val TITLE = "title"
        const val PICPATH = "picpath"
        const val PRICE = "price"
        const val TAX = "tax"
        const val STOCK = "stockunit"
        const val ITGRP_ID = "itemgrp1_id"
        const val LASTSYNC = "last_sync"
        const val BUCKET = "bucket"
        const val OBJKEY = "objkey"
        const val TEMPURL = "temp_url"
        const val SALEUNIT = "saleunit"
        const val ACTIVE = "active"
        const val ITEMQTY = "itemqty"
        const val ISPOS = "ispos"
        const val FAVORIT = "favorit"
        const val TYPE = "type"
        const val VARIANT = "is_variant"
        const val AVAILABLE = "is_available"
        const val USEPID = "usepid"
        const val VCODE = "vcode"
        const val VCOLOR = "vcolor"

    }
}