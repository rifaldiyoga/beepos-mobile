package com.bits.bee.bpmc.presentation.ui.transaksi_penjualan

import com.bits.bee.bpmc.domain.model.Sale

/**
 * Created by aldi on 23/06/22.
 */
data class TransaksiPenjualanState (
    var saleList : List<Sale> = mutableListOf()
)