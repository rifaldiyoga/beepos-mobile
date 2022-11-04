package com.bits.bee.bpmc.presentation.ui.pembayaran_gopay

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Pmtd
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled

/**
 * Created by aldi on 02/06/22.
 */
data class PembayaranGopayState(
    var pmtd : Pmtd? = null,
    var sale : Sale? = null,
    var saledList : List<Saled> = mutableListOf(),
    var bp: Bp? = null
)