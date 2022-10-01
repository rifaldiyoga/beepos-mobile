package com.bits.bee.bpmc.presentation.ui.rekap_kas

import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.model.Cashier

data class KasKeluarMasukState(
    var view: String="",
    var user: String? = null,
    var activeCashier: Cashier? = null,
    var activeBranch: Branch? = null,
    var cadjList: List<Cadj>? = null
)