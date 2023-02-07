package com.bits.bee.bpmc.presentation.ui.rekap_kas

import com.bits.bee.bpmc.domain.model.*

data class KasKeluarMasukState(
    var view: String="",
    var user: String? = null,
    var activeCashier: Cashier? = null,
    var activeBranch: Branch? = null,
    var acrivePosses: Posses? = null,
    var cadjListIn: List<Cadj>? = null,
    var cashInList: MutableList<Kas>? = null,
    var cadjListOut: List<Cadj>? = null,
    var cashOutList: MutableList<Kas>? = null,
    var isDesc: Boolean = true,
    var search: String = "",
    var listCadj: List<Cadj>? = null,
    var blockCashOut: Boolean = false,
    var msgKasKeluar: String? = null
)