package com.bits.bee.bpmc.presentation.ui.analisis_sesi

import com.bits.bee.bpmc.domain.model.*
import com.github.mikephil.charting.data.Entry
import java.math.BigDecimal

data class AnalisaSesiState(
    var posses: Posses? = null,
    var activeBranch: Branch? = null,
    var activeCashier: Cashier? = null,
    var user: User? = null,
    var possesList: List<Posses>? = null,
    var saleList: List<Sale>? = null,
    var bpDateList: List<Bp>? = null,
    var saledList: List<Saled>? = null,
    var setoranKasirData: SetoranKasirData? = null,
    var notaSucces: BigDecimal = BigDecimal.ZERO,
    var notaVoid: BigDecimal = BigDecimal.ZERO,
    var totalTunai: BigDecimal = BigDecimal.ZERO,
    var totalDebit: BigDecimal = BigDecimal.ZERO,
    var totalKredit: BigDecimal = BigDecimal.ZERO,
    var totalGopay: BigDecimal = BigDecimal.ZERO,
    var rankItem: List<RankItem>? = null,
    var reg: Reg? = null,
    var listEntry: List<Entry>? = null
)