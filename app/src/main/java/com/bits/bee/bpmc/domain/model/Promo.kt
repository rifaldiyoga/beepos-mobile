package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class Promo (
    var id : Int = -1,
    var isActive : Boolean = false,
    var isBranch : Boolean = false,
    var branchId: Int? = null,
    var isPeriod : Boolean = false,
    var startDate : String? = null,
    var endDate: String? = null,
    var isTime : Boolean = false,
    var startTime : String? = null,
    var endTime : String? = null,
    var isDow: Boolean = false,
    var dowExp : String? = null,
    var isBpgrp : Boolean = false,
    var bpgrpId : String? = null,
    var offerType : String = "",
    var minAmt : BigDecimal = BigDecimal.ZERO,
    var isTargetItem : Boolean = false,
    var itemId : Int? = null,
    var isTargetItgrp : Boolean = false,
    var itgrpId : Int? = null,
    var isTargetBrand : Boolean = false,
    var brandId : Int? = null,
    var isTargetVendor : Boolean = false,
    var vendorId : Int? = null,
    var isMinQty : Boolean = false,
    var minQty : BigDecimal? = null,
    var priority : Int = -1,
    var isMinAmt : Boolean = false,
    var note : String = "",
    var code : String = "",
    var promoType : String = "",
    var promoName : String = "",
    var itemDiscExp : String? = null,
    var promoCat : String = "",
    var isPriceOveride : Boolean = false,
    var dealItemId : Int? = null,
    var itemPrice : BigDecimal? = null,
    var isMinQtyMultiply : Boolean = false,
    var isMaxQty : Boolean = false,
    var maxQty : BigDecimal? = null,
    var isUsed : Boolean = false,
    var isOn : Boolean = false,
    var isMulti : Boolean = false,
    var dealQty : BigDecimal? = null,
    var isDealSameItem : Boolean = false,
) : Parcelable