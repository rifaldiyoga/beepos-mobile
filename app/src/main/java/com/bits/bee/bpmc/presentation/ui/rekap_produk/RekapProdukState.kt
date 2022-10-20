package com.bits.bee.bpmc.presentation.ui.rekap_produk

import com.bits.bee.bpmc.domain.model.Item

data class RekapProdukState(
    var itemList: List<Item>? = null,
    var selectFilter: String = "1 Minggu Terakhir",
    var itemListResult: List<Item>? = null,
    var searchQuery: String = ""
)