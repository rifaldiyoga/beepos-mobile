package com.bits.bee.bpmc.presentation.ui.detail_sesi_kasir

import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.User

data class DetailSesiKasirState(
    var posses: Posses? = null,
    var activeBranch: Branch? = null,
    var activeCashier: Cashier? = null,
    var user: User? = null
)