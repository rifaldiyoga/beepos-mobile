package com.bits.bee.bpmc.presentation.ui.detail_transaksi_penjualan

import com.bits.bee.bpmc.domain.model.*

/**
 * Created by aldi on 23/06/22.
 */
data class DetailTransaksiPenjualanState (
        var sale : Sale? = null,
        var saledList : List<Saled> = mutableListOf(),
        var saleAddOnDList : List<SaleAddOnD> = mutableListOf(),
        var saleCrcvList : List<SaleCrcv> = mutableListOf(),
        var crc: Crc? = null,
        var isAllowVoid : Boolean = true
)