package com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_produk.pilih_produk

import com.bits.bee.bpmc.domain.model.ItemGroup

/**
 * Created by aldi on 06/10/22
 */
data class PilihProdukState (
    val itemGroupList: MutableList<ItemGroup> = mutableListOf()
)