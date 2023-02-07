package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class SetoranKasirData(
    var saleList: List<Sale>? = null,
    var totalNewMember: Int = 0,
    var totalCash: BigDecimal = BigDecimal.ZERO,
    var totalCredit : BigDecimal = BigDecimal.ZERO,
    var totalDebit: BigDecimal = BigDecimal.ZERO,
    var totalGopay: BigDecimal = BigDecimal.ZERO,
    var totalAvg: BigDecimal = BigDecimal.ZERO,
    var totalQty: BigDecimal = BigDecimal.ZERO,
    var totalVoid: BigDecimal = BigDecimal.ZERO,
    var totalNota: BigDecimal = BigDecimal.ZERO
): Parcelable