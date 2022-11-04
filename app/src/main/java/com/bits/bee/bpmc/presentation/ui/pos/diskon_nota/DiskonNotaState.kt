package com.bits.bee.bpmc.presentation.ui.pos.diskon_nota

import java.math.BigDecimal

/**
 * Created by aldi on 27/06/22.
 */
data class DiskonNotaState (
    var diskon : String = "",
    var subtotal : BigDecimal = BigDecimal.ZERO,
    var isEditDisc : Boolean = true
)