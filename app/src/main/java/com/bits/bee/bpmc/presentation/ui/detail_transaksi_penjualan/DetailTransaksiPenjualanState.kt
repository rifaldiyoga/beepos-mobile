package com.bits.bee.bpmc.presentation.ui.detail_transaksi_penjualan

import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled

/**
 * Created by aldi on 23/06/22.
 */
data class DetailTransaksiPenjualanState (
        var sale : Sale? = null,
        var saledList : List<Saled> = mutableListOf()
)