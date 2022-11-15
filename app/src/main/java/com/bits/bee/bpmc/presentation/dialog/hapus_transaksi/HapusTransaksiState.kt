package com.bits.bee.bpmc.presentation.dialog.hapus_transaksi

import com.bits.bee.bpmc.domain.model.Sale

/**
 * Created by aldi on 04/11/22
 */
data class HapusTransaksiState (
    var sale : Sale? = null,
    var alasan : String = "",
    var isCanVoid : Boolean = true
)