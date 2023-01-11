package com.bits.bee.bpmc.presentation.ui.analisis_sesi

import com.bits.bee.bpmc.domain.model.*
import com.github.mikephil.charting.data.Entry
import java.math.BigDecimal

data class AnalisaSesiState(
    var posses: Posses? = null,
    var activeBranch: Branch? = null,
    var activeCashier: Cashier? = null,
    var user: User? = null,
    var possesList: List<Posses> = mutableListOf(),
    var saleList: List<Sale> = mutableListOf(),
    var bpDateList: List<Bp> = mutableListOf(),
    var saledList: List<Saled> = mutableListOf(),
    var setoranKasirData: SetoranKasirData? = null,
    var notaSucces: BigDecimal = BigDecimal.ZERO,
    var notaVoid: BigDecimal = BigDecimal.ZERO,
    var totalTunai: BigDecimal = BigDecimal.ZERO,
    var totalDebit: BigDecimal = BigDecimal.ZERO,
    var totalKredit: BigDecimal = BigDecimal.ZERO,
    var totalGopay: BigDecimal = BigDecimal.ZERO,
    var rankItem: List<RankItem> = mutableListOf(),
    var listEntry: List<Entry> = mutableListOf()
)