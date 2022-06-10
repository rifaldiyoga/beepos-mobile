package com.bits.bee.bpmc.presentation.ui.buka_kasir

import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.Posses
import java.math.BigDecimal

/**
 * Created by aldi on 08/06/22.
 */

data class DetailBukaKasirState (
    var posses : Posses? = null,
    var branch : Branch? = null,
    var cashier : Cashier? = null,
    var shift : Int = 1,
    var modal : BigDecimal? = null,
    var defaultModal : BigDecimal = BigDecimal.ZERO
)