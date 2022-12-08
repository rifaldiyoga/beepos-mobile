package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.kategori

import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.model.KategoriProduk

data class TambahUbahKategoriState(
    var namaKategori: String = "",
    var useSubKategori: Boolean = false,
    var subKategori: String ="",
    var katPrdList: List<KategoriProduk>? = null,
    var kategoriList: List<String>? = null,
    var itemgrp: ItemGroup? = null,
    var isEdit: Boolean = false,
    var olId: Int = -1,
    var msgNama: String =""
)