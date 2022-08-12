package com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi

import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.User

data class DetailRiwayatSesiState(
    var posses: Posses? = null,
    var activeBranch: Branch? = null,
    var cashier: Cashier? = null,
    var user: User? = null
)