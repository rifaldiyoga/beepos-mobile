package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import java.math.BigDecimal

@Entity(tableName = Item.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Itemgrp::class,
            parentColumns = [Itemgrp.ID],
            childColumns = [Item.ITGRP_ID],
            onDelete = CASCADE
        )
    ]
)
data class Item(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = TITLE)
    val title: String,
    @ColumnInfo(name = PICPATH)
    val picPath: String,
    @ColumnInfo(name = PRICE)
    val price : BigDecimal,
    @ColumnInfo(name = TAX)
    val tax : String,
    @ColumnInfo(name = ITGRP_ID, index = true)
    val itgrpId: Int,
    @ColumnInfo(name = BUCKET)
    val bucket : Long,
    @ColumnInfo(name = OBJKEY)
    val objKey : String,
    @ColumnInfo(name = TEMPURL)
    val tempUrl : String,
    @ColumnInfo(name = SALEUNIT)
    val saleUnit : String,
    @ColumnInfo(name = ACTIVE)
    val isActive : Boolean,
    @ColumnInfo(name = ITEMQTY)
    val itemQty : Int = 0,
    @ColumnInfo(name = ISPOS)
    val isPos : Boolean,
    @ColumnInfo(name = TYPE)
    val type : String,
    @ColumnInfo(name = FAVORIT)
    val isFavorit : Boolean,
    @ColumnInfo(name = AVAILABLE)
    val isAvailable : Boolean = true,
    @ColumnInfo(name = VARIANT)
    val isVariant : Boolean = false,
    @ColumnInfo(name = USEPID)
    val usePid : Boolean = false,
    @ColumnInfo(name = VCODE)
    val vCode : String,
    @ColumnInfo(name = VCOLOR)
    val vColor : String,
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