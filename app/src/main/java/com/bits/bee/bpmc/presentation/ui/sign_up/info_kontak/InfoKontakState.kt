package com.bits.bee.bpmc.presentation.ui.sign_up.info_kontak

data class InfoKontakState(
    var nama: String = "",
    var noWa : String = "",
    var email: String = "",
    var password: String = "",
    var confPassword: String = "",
    var isValid: Boolean = false,
    var regId : String = ""
)