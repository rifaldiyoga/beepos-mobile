package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.merek

import com.bits.bee.bpmc.domain.model.Brand

data class TambahUbahMerekState(
    var namaMerek: String="",
    var listBrand: List<Brand>? = null,
    var merekList: List<String>? = null,
    var isEdit: Boolean = false,
    var olId: Int = -1,
    var brand: Brand? = null
)