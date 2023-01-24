package com.bits.bee.bpmc.presentation.ui.home

import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.domain.model.Posses

/**
 * Created by aldi on 14/06/22.
 */
data class HomeState (
    var activePosses : Posses? = null,
    var activeCashier : Cashier? = null,
    var activeBranch : Branch? = null,
    var activeLicense : License? = null,
    var isShowLicense : Boolean = false,
    var shift : Int = 1
)