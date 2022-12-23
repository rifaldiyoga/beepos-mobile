package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = ItemEntity.TBL_NAME,
//    foreignKeys = [
//        ForeignKey(
//            entity = ItemGroupEntity::class,
//            parentColumns = [ItemGroupEntity.ID],
//            childColumns = [ItemEntity.ITGRP_ID],
//        )
//    ]
)
data class ItemEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name= ID)
    var id : Int,
    @ColumnInfo(name= CODE)
    var code : String,
    @ColumnInfo(name= NAME1)
    var name1: String,
    @ColumnInfo(name= BRAND_ID)
    var brandId: Int?,
    @ColumnInfo(name= ITEMTYPE_CODE)
    var itemTypeCode : String,
    @ColumnInfo(name= USEPID)
    var usePid : Boolean,
    @ColumnInfo(name= UNIQUEPID)
    var uniquePid: Boolean,
    @ColumnInfo(name= ITEMGRP_ID)
    var itemGrpId : Int?,
    @ColumnInfo(name= ISSTOCK)
    var isStock : Boolean,
    @ColumnInfo(name= ISSALE)
    var isSale : Boolean,
    @ColumnInfo(name= UNITDESC)
    var unitdesc : String,
    @ColumnInfo(name= NOTE)
    var note : String?,
    @ColumnInfo(name= ACTIVE)
    var active : Boolean,
    @ColumnInfo(name= SALEUNIT)
    var saleUnit : Int?,
    @ColumnInfo(name= STOCKUNIT)
    var stockUnit : Int?,
    @ColumnInfo(name = ITEMQTY)
    var qty : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = ISPOS)
    var isPos : Boolean = true,
    @ColumnInfo(name = TYPE)
    var type : String = "",
    @ColumnInfo(name = FAVORIT)
    var isFavorit : Boolean = false,
    @ColumnInfo(name = AVAILABLE)
    var isAvailable : Boolean = true,
    @ColumnInfo(name = VARIANT)
    var isVariant : Boolean = false,
    @ColumnInfo(name = VCODE)
    var vCode : String? = "",
    @ColumnInfo(name = VCOLOR)
    var vColor : String? = "",
    @ColumnInfo(name = BARCODE)
    var barCode : String? = "",
) {
    companion object {
        const val TBL_NAME = "item"

        const val ID = "id"
        const val CODE = "code"
        const val NAME1 = "name1"
        const val BRAND_ID = "brand_id"
        const val ITEMTYPE_CODE = "itemtype_code"
        const val UNIQUEPID = "uniquepid"
        const val ITEMGRP_ID = "itemgrp1_id"
        const val ISSTOCK = "isstock"
        const val ISSALE = "issale"
        const val UNITDESC = "unitdesc"
        const val NOTE = "note"
        const val ITGRP_ID = "itemgrp1_id"
        const val LASTSYNC = "last_sync"
        const val BUCKET = "bucket"
        const val OBJKEY = "objkey"
        const val TEMPURL = "temp_url"
        const val SALEUNIT = "saleunit"
        const val STOCKUNIT = "stockunit"
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
        const val BARCODE = "barcode"

    }
}