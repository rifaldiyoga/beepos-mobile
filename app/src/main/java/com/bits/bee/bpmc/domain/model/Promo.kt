package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.PromoEntity
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
    var branchId: Int,
    var isPeriod : Boolean,
    var startDate : String,
    var endDate: String,
    var isTime : Boolean,
    var startTime : String,
    var endTime : String,
    var isDow: Boolean,
    var dowExp : String,
    var isBpgrp : Boolean,
    var offerType : String,
    var minAmt : BigDecimal,
    var isTargetItem : Boolean,
    var itemId : Int,
    var isTargetItgrp : Boolean,
    var itgrpId : Int,
    var isTargetBrand : Boolean,
    var brandId : Int,
    var isTargetVendor : Boolean,
    var vendorId : Int,
    var isMinQty : Boolean,
    var minQty : Int,
    var priority : Int,
    var isMinAmt : Int,
    var note : String,
    var code : String,
    var promoType : String,
    var promoName : String,
    var itemDiscExp : String,
    var promoCat : String,
    var isPriceOveride : Boolean,
    var dealItemId : Int,
    var itemPrice : BigDecimal,
    var isMinQtyMultiply : Boolean,
    var isMaxQty : Boolean,
    var maxQty : Int,
    var isUsed : Boolean,
    var isOn : Boolean,
    var isMulti : Boolean,
    var dealQty : Int,
    var isDealSameItem : Boolean,
) : Parcelable