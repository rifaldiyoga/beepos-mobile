package com.bits.bee.bpmc.presentation.ui.setting_nota

data class SettingNotaState(
    var useLogo: Boolean = false,
    var useLogoGalery: Boolean = false,
    var useHeader: Boolean = false,
    var useFooter: Boolean = false,
    var filePath: String = ""
    )