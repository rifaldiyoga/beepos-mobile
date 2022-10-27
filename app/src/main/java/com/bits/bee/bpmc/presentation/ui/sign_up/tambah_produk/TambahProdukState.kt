package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.model.UnitDummy

/**
 * Created by aldi on 31/08/22.
 */
data class TambahProdukState (
    var nama : String = "",
    var harga : String = "",
    var satuan : String = "",
    var tipeProduk : String = "",
    var kategoriProduk : String = "",
    var itemDummy: ItemDummy? = null,
    var unitList : MutableList<UnitDummy> = mutableListOf()
)