package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 15/07/22.
 */
@Parcelize
data class Stock(
    var id : Int?,
    var itemId: Int = -1,
    var whId: Int = -1,
    var itemCode: String = "",
    var whCode: String? = "",
    var pid: String = "",
    var qty: String = "",
    var qtyx: String = "",
    var active: Boolean = false,
    var itemName : String = "",
    var harga : BigDecimal = BigDecimal.ZERO,
    var symbol : String = "",
) : Parcelable