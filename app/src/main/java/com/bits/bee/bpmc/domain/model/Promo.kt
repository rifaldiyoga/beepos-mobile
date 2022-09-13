package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class Promo (
    var id : Int,
    var isActive : Boolean,
    var isBranch : Boolean,
    var branchId: Int?,
    var isPeriod : Boolean,
    var startDate : String?,
    var endDate: String?,
    var isTime : Boolean,
    var startTime : String?,
    var endTime : String?,
    var isDow: Boolean,
    var dowExp : String?,
    var isBpgrp : Boolean,
    var bpgrpId : String?,
    var offerType : String,
    var minAmt : BigDecimal,
    var isTargetItem : Boolean,
    var itemId : Int?,
    var isTargetItgrp : Boolean,
    var itgrpId : Int?,
    var isTargetBrand : Boolean,
    var brandId : Int?,
    var isTargetVendor : Boolean,
    var vendorId : Int?,
    var isMinQty : Boolean,
    var minQty : BigDecimal?,
    var priority : Int,
    var isMinAmt : Boolean,
    var note : String,
    var code : String,
    var promoType : String,
    var promoName : String,
    var itemDiscExp : String?,
    var promoCat : String,
    var isPriceOveride : Boolean,
    var dealItemId : Int?,
    var itemPrice : BigDecimal?,
    var isMinQtyMultiply : Boolean,
    var isMaxQty : Boolean,
    var maxQty : BigDecimal?,
    var isUsed : Boolean = false,
    var isOn : Boolean = false,
    var isMulti : Boolean,
    var dealQty : BigDecimal?,
    var isDealSameItem : Boolean,
) : Parcelable