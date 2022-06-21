package com.bits.bee.bpmc.presentation.dialog.atur_modal

import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import java.math.BigDecimal

/**
 * Created by aldi on 15/06/22.
 */
data class AturModalState (
    var modal : BigDecimal? = null,
    var defaultModal : BigDecimal = BigDecimal(100000),
    var activeBranch : Branch? = null,
    var activeCashier : Cashier? = null,
    var shift : Int = 1,
)