package com.bits.bee.bpmc.presentation.ui.pembayaran

import java.math.BigDecimal

/**
 * Created by aldi on 25/05/22.
 */
data class PembayaranState (
    var total : BigDecimal,
    var rekomBayarList : MutableMap<String, String> = mutableMapOf()
)