package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.kategori

import com.bits.bee.bpmc.domain.model.ItemGroup

data class TambahUbahKategoriState(
    var namaKategori: String = "",
    var useSubKategori: Boolean = false,
    var subKategori: String ="",
    var itemGroupList: List<ItemGroup> = mutableListOf(),
    var itemgrp: ItemGroup? = null,
    var isEdit: Boolean = false,
    var olId: Int = -1,
    var msgNama: String =""
)