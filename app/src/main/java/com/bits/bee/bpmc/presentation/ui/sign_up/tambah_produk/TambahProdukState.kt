package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import android.graphics.Bitmap
import com.bits.bee.bpmc.domain.model.*

/**
 * Created by aldi on 31/08/22.
 */
data class TambahProdukState (
    var nama : String = "",
    var harga : String = "",
    var satuan : String = "",
    var tipeProduk : String = "",
    var itemGrp : ItemGroup? = null,
    var brand : Brand? = null,
    var itemDummy: ItemDummy? = null,
    var unitList : MutableList<UnitDummy> = mutableListOf(),
    var listKategoriPrd: List<KategoriProduk>? = null,
    var kategoriProduk: String? = null,
    var listBrand: List<Brand>? = null,
    var merekProduk: String? = null,
    var bitmap: Bitmap? = null,
    var picpath: String ="",
    var isEdit: Boolean = false,
    var itemId: Int = -1,
    var isActivePid: Boolean = false,
    var pid: String = ""
)