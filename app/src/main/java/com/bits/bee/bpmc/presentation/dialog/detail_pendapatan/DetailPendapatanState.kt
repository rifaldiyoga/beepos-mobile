package com.bits.bee.bpmc.presentation.dialog.detail_pendapatan

import com.bits.bee.bpmc.domain.model.Posses
import java.math.BigDecimal

data class DetailPendapatanState(
    var posses: Posses? = null,
    var totalTunai: BigDecimal? = null,
    var totalDebit: BigDecimal? = null,
    var totalKredit: BigDecimal? = null,
    var totalGopay: BigDecimal? = null,
)