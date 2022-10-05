package com.bits.bee.bpmc.presentation.ui.rekap_kas

import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.Kas

data class KasKeluarMasukState(
    var view: String="",
    var user: String? = null,
    var activeCashier: Cashier? = null,
    var activeBranch: Branch? = null,
    var cadjListIn: List<Cadj>? = null,
    var cashInList: MutableList<Kas>? = null,
    var cadjListOut: List<Cadj>? = null,
    var cashOutList: MutableList<Kas>? = null
)