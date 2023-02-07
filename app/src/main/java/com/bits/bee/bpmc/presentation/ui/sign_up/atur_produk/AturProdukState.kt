package com.bits.bee.bpmc.presentation.ui.sign_up.atur_produk

import com.bits.bee.bpmc.domain.model.ItemDummy

/**
 * Created by aldi on 31/08/22.
 */
data class AturProdukState (
    var itemList : List<ItemDummy> = mutableListOf()
)