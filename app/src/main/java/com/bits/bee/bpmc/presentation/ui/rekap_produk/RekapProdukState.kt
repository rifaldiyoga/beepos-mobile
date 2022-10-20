package com.bits.bee.bpmc.presentation.ui.rekap_produk

import com.bits.bee.bpmc.domain.model.Item

data class RekapProdukState(
    var itemList: MutableList<Item>? = null
)