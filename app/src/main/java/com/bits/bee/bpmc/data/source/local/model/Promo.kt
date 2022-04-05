package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = Promo.TBL_NAME)
data class Promo(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = IS_ACTIVE)
    var isActive : Boolean,
    @ColumnInfo(name = IS_BRANCH)
    var isBranch : Boolean,
    @ColumnInfo(name = BRANCH_ID)
    var branchId: Int,
    @ColumnInfo(name = IS_PERIODE)
    var isPeriod : Boolean,
    @ColumnInfo(name = START_DATE)
    var startDate : String,
    @ColumnInfo(name = END_DATE)
    var endDate: String ,
    @ColumnInfo(name = IS_TIME)
    var isTime : Boolean,
    @ColumnInfo(name = START_TIME)
    var startTime : String,
    @ColumnInfo(name = END_TIME)
    var endTime : String,
    @ColumnInfo(name = IS_DOW)
    var isDow: Boolean,
    @ColumnInfo(name = DOWEXP)
    var dowExp : String,
    @ColumnInfo(name = IS_BPGRP)
    var isBpgrp : Boolean,
    @ColumnInfo(name = OFFER_TYPE)
    var offerType : String,
    @ColumnInfo(name = MIN_AMT)
    var minAmt : BigDecimal,
    @ColumnInfo(name = IS_TARGET_ITEM)
    var isTargetItem : Boolean,
    @ColumnInfo(name = ITEM_ID)
    var itemId : Int,
    @ColumnInfo(name = IS_TARGET_ITGRP)
    var isTargetItgrp : Boolean,
    @ColumnInfo(name = ITGRP_ID)
    var itgrpId : Int,
    @ColumnInfo(name = IS_TARGETBRAND)
    var isTargetBrand : Boolean,
    @ColumnInfo(name = BRAND_ID)
    var brandId : Int,
    @ColumnInfo(name = IS_TARGET_VENDOR)
    var isTargetVendor : Boolean,
    @ColumnInfo(name = VENDOR_ID)
    var vendorId : Int,
    @ColumnInfo(name = IS_MIN_QTY)
    var isMinQty : Boolean,
    @ColumnInfo(name = MIN_QTY)
    var minQty : Int,
    @ColumnInfo(name = PRIORITY)
    var priority : Int,
    @ColumnInfo(name = IS_MIN_AMT)
    var isMinAmt : Int,
    @ColumnInfo(name = NOTE)
    var note : String,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = PROMO_TYPE)
    var promoType : String,
    @ColumnInfo(name = PROMO_NAME)
    var promoName : String,
    @ColumnInfo(name = ITEM_DISC_EXP)
    var itemDiscExp : String,
    @ColumnInfo(name = PROMO_CAT)
    var promoCat : String,
    @ColumnInfo(name = IS_PRICE_OVERIDE)
    var isPriceOveride : Boolean,
    @ColumnInfo(name = DEAL_ITEM_ID)
    var dealItemId : Int,
    @ColumnInfo(name = ITEM_PRICE)
    var itemPrice : BigDecimal,
    @ColumnInfo(name = IS_MIN_QTY_MULTIPLY)
    var isMinQtyMultiply : Boolean,
    @ColumnInfo(name = IS_MAX_QTY)
    var isMaxQty : Boolean,
    @ColumnInfo(name = MAX_QTY)
    var maxQty : Int,
    @ColumnInfo(name = IS_USED)
    var isUsed : Boolean,
    @ColumnInfo(name = IS_ON)
    var isOn : Boolean,
    @ColumnInfo(name = ISMULTI)
    var isMulti : Boolean,
    @ColumnInfo(name = DEAL_QTY)
    var dealQty : Int,
    @ColumnInfo(name = IS_DEAL_SAME_ITEM)
    var isDealSameItem : Boolean,
) {
    companion object {
        const val TBL_NAME = "promo"

        const val ID = "id"
        const val CODE = "code"
        const val PROMO_TYPE = "promotype"
        const val RABATID = "rabatid"
        const val PROMO_NAME = "name"
        const val IS_ACTIVE = "isactive"
        const val IS_BRANCH = "isbranch"
        const val BRANCH_ID = "branchid"
        const val IS_PERIODE = "isperiode"
        const val START_DATE = "startdate"
        const val END_DATE = "enddate"
        const val IS_TIME = "istime"
        const val START_TIME = "starttime"
        const val END_TIME = "endtime"
        const val IS_DOW = "isdow"
        const val DOWEXP = "dowexp"
        const val IS_BPGRP = "isbpgrp"
        const val BPGRP_ID = "bpgrpid"
        const val OFFER_TYPE = "offertype"
        const val IS_MIN_AMT = "isminamt"
        const val MIN_AMT = "minamt"
        const val IS_SEAT_LIMIT = "isseatlimit"
        const val SEAT_LIMIT = "seatlimit"
        const val SEAT_LIMIT_TYPE = "seatlimittype"
        const val IS_TARGET_ITEM = "istargetitem"
        const val ITEM_ID = "itemid"
        const val IS_TARGET_ITGRP = "istargetitgrp"
        const val ITGRP_ID = "itgrpid"
        const val IS_TARGETBRAND = "istargetbrand"
        const val BRAND_ID = "brandid"
        const val IS_TARGET_VENDOR = "istargetvendor"
        const val VENDOR_ID = "vendorid"
        const val IS_PERSONAL_LIMIT = "ispersonallimit"
        const val PERSONAL_LIMIT = "personallimit"
        const val PERSONAL_LIMIT_TYPE = "personallimittype"
        const val IS_PAYMENT = "ispayment"
        const val PAYMENT_TYPE = "paymenttype"
        const val IS_MIN_QTY = "isminqty"
        const val MIN_QTY = "minqty"
        const val IS_MIN_QTY_MULTIPLY = "isminqtymultiply"
        const val IS_MAX_QTY = "ismaxqty"
        const val MAX_QTY = "maxqty"
        const val PRIORITY = "priority"
        const val DEAL_TYPE_ID = "dealtypeid"
        const val IS_DEAL_SAME_ITEM = "isdealsameitem"
        const val IS_OTHER_ITEM = "isotheritem"
        const val IS_ALL_ITEM = "isallitem"
        const val IS_BONUS_ITEM = "isbonusitem"
        const val IS_KUPON = "iskupon"
        const val IS_POINT = "ispoint"
        const val IS_LUCKY_PRIZE = "isluckyprize"
        const val DEAL_ITEM_ID = "deal_itemid"
        const val DEAL_QTY = "deal_qty"
        const val IS_PRICE_OVERIDE = "ispriceoveride"
        const val ITEM_PRICE = "itemprice"
        const val IS_DISKON = "isdiskon"
        const val ITEM_DISC_EXP = "itemdiscexp"
        const val CUST_POINT_ID = "custpointid"
        const val PRIZE_EVERY = "prizeevery"
        const val CRT_BY = "crtby"
        const val CRT_DATE = "crtdate"
        const val UPD_BY = "updby"
        const val UPD_DATE = "upddate"
        const val NOTE = "note"
        const val PROMO_CAT = "promo_cat"
        const val IS_USED = "isused"

        const val ISMULTI = "ismulti"

        const val IS_ON = "ison"

        const val DISC = "XX"
        const val XY = "XY"
        const val MINAMT = "MIN"
        const val BONUS = "BONUS"
        const val OFFERTYPE_HEADER = "HEADER"
        const val OFFERTYPE_DETAIL = "DETAIL"
    }
}