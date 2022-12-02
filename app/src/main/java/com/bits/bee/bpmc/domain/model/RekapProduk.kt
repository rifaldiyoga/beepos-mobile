package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
import java.util.*

@Parcelize
data class RekapProduk(
    var itemId: Int,
    var itemCode: String,
    var name: String,
    var qty: BigDecimal? = null,
    var subtotal : BigDecimal? = null,
    var draft: Boolean = false,
    var isVoid: Boolean = false,
    var trxDate: Date? = null
): Parcelable