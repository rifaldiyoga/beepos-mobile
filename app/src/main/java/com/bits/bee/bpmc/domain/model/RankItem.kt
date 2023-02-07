package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class RankItem(
    var name: String = "",
    var qty: BigDecimal = BigDecimal.ZERO,
    var total: BigDecimal = BigDecimal.ZERO
): Parcelable