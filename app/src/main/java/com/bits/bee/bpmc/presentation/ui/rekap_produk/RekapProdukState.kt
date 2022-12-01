package com.bits.bee.bpmc.presentation.ui.rekap_produk

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Stock

data class RekapProdukState(
    var itemList: List<Item>? = null,
    var itemListResult: List<Item>? = null,
    var searchQuery: String = "",
    var resultFilteritem: List<Item>? = null,
    var item: Item? = null,
    var listPid: List<Stock>? = null,
    var selectPos: Int = 0
)