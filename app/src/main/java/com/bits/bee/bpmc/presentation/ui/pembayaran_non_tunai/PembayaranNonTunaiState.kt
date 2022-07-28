package com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai

import com.bits.bee.bpmc.domain.model.Pmtd

/**
 * Created by aldi on 27/06/22.
 */
data class PembayaranNonTunaiState (
    var pmtdList : List<Pmtd> = mutableListOf()
)