package com.bits.bee.bpmc.presentation.ui.buka_kasir

import com.bits.bee.bpmc.domain.model.*

/**
 * Created by aldi on 20/06/22.
 */
data class BukaTutupKasirState(
    var activePosses : Posses? = null,
    var activeCashier : Cashier? = null,
    var activeBranch : Branch? = null,
    var shift : Int = 1,
    var listCasha: List<CashA>? = null,
    var user: User? = null,
    var crc : Crc? = null
)