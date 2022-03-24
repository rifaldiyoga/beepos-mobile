package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = Promo.TBL_NAME)
data class Promo(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = IS_ACTIVE)
    val isActive : Boolean,
    @ColumnInfo(name = IS_BRANCH)
    val isBranch : Boolean,
    @ColumnInfo(name = BRANCH_ID)
    val branchId: Int,
    @ColumnInfo(name = IS_PERIODE)
    val isPeriod : Boolean,
    @ColumnInfo(name = START_DATE)
    val startDate : String,
    @ColumnInfo(name = END_DATE)
    val endDate: String ,
    @ColumnInfo(name = IS_TIME)
    val isTime : Boolean,
    @ColumnInfo(name = START_TIME)
    val startTime : String,
    @ColumnInfo(name = END_TIME)
    val endTime : String,
    @ColumnInfo(name = IS_DOW)
    val isDow: Boolean,
    @ColumnInfo(name = DOWEXP)
    val dowExp : String,
    @ColumnInfo(name = IS_BPGRP)
    val isBpgrp : Boolean,
    @ColumnInfo(name = OFFER_TYPE)
    val offerType : String,
    @ColumnInfo(name = MIN_AMT)
    val minAmt : BigDecimal,
    @ColumnInfo(name = IS_TARGET_ITEM)
    val isTargetItem : Boolean,
    @ColumnInfo(name = ITEM_ID)
    val itemId : Int,
    @ColumnInfo(name = IS_TARGET_ITGRP)
    val isTargetItgrp : Boolean,
    @ColumnInfo(name = ITGRP_ID)
    val itgrpId : Int,
    @ColumnInfo(name = IS_TARGETBRAND)
    val isTargetBrand : Boolean,
    @ColumnInfo(name = BRAND_ID)
    val brandId : Int,
    @ColumnInfo(name = IS_TARGET_VENDOR)
    val isTargetVendor : Boolean,
    @ColumnInfo(name = VENDOR_ID)
    val vendorId : Int,
    @ColumnInfo(name = IS_MIN_QTY)
    val isMinQty : Boolean,
    @ColumnInfo(name = MIN_QTY)
    val minQty : Int,
    @ColumnInfo(name = PRIORITY)
    val priority : Int,
    @ColumnInfo(name = IS_MIN_AMT)
    val isMinAmt : Int,
    @ColumnInfo(name = NOTE)
    val note : String,
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = PROMO_TYPE)
    val promoType : String,
    @ColumnInfo(name = PROMO_NAME)
    val promoName : String,
    @ColumnInfo(name = ITEM_DISC_EXP)
    val itemDiscExp : String,
    @ColumnInfo(name = PROMO_CAT)
    val promoCat : String,
    @ColumnInfo(name = IS_PRICE_OVERIDE)
    val isPriceOveride : Boolean,
    @ColumnInfo(name = DEAL_ITEM_ID)
    val dealItemId : Int,
    @ColumnInfo(name = ITEM_PRICE)
    val itemPrice : BigDecimal,
    @ColumnInfo(name = IS_MIN_QTY_MULTIPLY)
    val isMinQtyMultiply : Boolean,
    @ColumnInfo(name = IS_MAX_QTY)
    val isMaxQty : Boolean,
    @ColumnInfo(name = MAX_QTY)
    val maxQty : Int,
    @ColumnInfo(name = IS_USED)
    val isUsed : Boolean,
    @ColumnInfo(name = IS_ON)
    val isOn : Boolean,
    @ColumnInfo(name = ISMULTI)
    val isMulti : Boolean,
    @ColumnInfo(name = DEAL_QTY)
    val dealQty : Int,
    @ColumnInfo(name = IS_DEAL_SAME_ITEM)
    val isDealSameItem : Boolean,
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