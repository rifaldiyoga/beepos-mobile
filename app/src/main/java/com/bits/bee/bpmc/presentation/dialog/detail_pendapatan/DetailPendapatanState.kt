package com.bits.bee.bpmc.presentation.dialog.detail_pendapatan

import com.bits.bee.bpmc.domain.model.Posses
import java.math.BigDecimal

data class DetailPendapatanState(
    var posses: Posses? = null,
    var totalTunai: BigDecimal = BigDecimal.ZERO,
    var totalDebit: BigDecimal = BigDecimal.ZERO,
    var totalKredit: BigDecimal = BigDecimal.ZERO,
    var totalGopay: BigDecimal = BigDecimal.ZERO,
)