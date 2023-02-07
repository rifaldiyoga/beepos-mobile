package com.bits.bee.bpmc.presentation.ui.sign_up.info_bisnis

import com.bits.bee.bpmc.domain.model.SignUp

data class InfoBisnisState(
    var isValid : Boolean = false,
    var namaPerusahaan: String = "",
    var tipeUsaha: String = "",
    var kota: String = "",
    var alamat: String = "",
    var signUp : SignUp? = null
)