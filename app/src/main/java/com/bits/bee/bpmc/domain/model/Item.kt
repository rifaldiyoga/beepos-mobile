package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 12/05/22.
 */
@Parcelize
data class Item (
    var id : Int,
    var code : String,
    var name1: String,
    var brandId: Int?,
    var itemTypeCode : String,
    var usePid : Boolean,
    var uniqueid: Boolean,
    var itemGrpId : Int?,
    var isStock : Boolean,
    var isSale : Boolean,
    var unitdesc : String,
    var note : String?,
    var active : Boolean,
    var saleUnit : Int,
    var stockUnit : Int,
    var qty : BigDecimal = BigDecimal.ZERO,
    var isPos : Boolean = true,
    var type : String = "",
    var isAvailable : Boolean = true,
    var isVariant : Boolean = false,
    var vCode : String? = null,
    var vColor : String? = null,
    var price : BigDecimal = BigDecimal.ZERO,
    var tax : String = "",
) : Parcelable