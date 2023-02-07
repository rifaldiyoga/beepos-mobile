package com.bits.bee.bpmc.presentation.ui.pembayaran_kartu

import com.bits.bee.bpmc.domain.model.Pmtd
import java.math.BigDecimal

/**
 * Created by aldi on 02/06/22.
 */
data class PembayaranKartuState (
    var pmtd : Pmtd? = null,
    var type : String = "",
    var trackNo : String = "",
    var nomorkartu : String = "",
    var keterangan : String = "",
    var nominalSurc : BigDecimal = BigDecimal.ZERO,
    var total : BigDecimal = BigDecimal.ZERO
)