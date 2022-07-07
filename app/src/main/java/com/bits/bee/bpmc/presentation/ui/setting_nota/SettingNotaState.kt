package com.bits.bee.bpmc.presentation.ui.setting_nota

data class SettingNotaState(
    var useLogo: Boolean = false,
    var useLogoGalery: Boolean = false,
    var useHeader: Boolean = false,
    var useFooter: Boolean = false,
    var useRekapCustomer: Boolean = false,
    var useRekapProdukChannel: Boolean = false,
    var useRekapFaktur: Boolean = false,
    var useRekapChannel: Boolean = false,
    var filePath: String = ""
    )