package com.bits.bee.bpmc.presentation.ui.cek_stok

import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Stock

data class CekStokState(
    var lastSync: String="",
    var stockList: List<Stock>? = null,
    var itemsList: List<Item>? = null,
    var itemListResult: List<Item>? = null
)