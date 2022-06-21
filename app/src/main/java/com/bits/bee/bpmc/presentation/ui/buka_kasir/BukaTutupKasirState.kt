package com.bits.bee.bpmc.presentation.ui.buka_kasir

import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.Posses

/**
 * Created by aldi on 20/06/22.
 */
data class BukaTutupKasirState(
    var activePosses : Posses? = null,
    var activeCashier : Cashier? = null,
    var activeBranch : Branch? = null,
    var shift : Int = 1
)