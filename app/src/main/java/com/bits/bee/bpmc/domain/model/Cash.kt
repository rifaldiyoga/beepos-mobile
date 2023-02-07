package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Cash(
    var id:  Int? = null,
    var code: String,
    var name: String,
    var balance: BigDecimal
): Parcelable