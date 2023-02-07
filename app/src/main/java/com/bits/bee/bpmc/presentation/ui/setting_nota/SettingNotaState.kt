package com.bits.bee.bpmc.presentation.ui.setting_nota

data class SettingNotaState(
    var isLogo: Boolean = false,
    var isHeader: Boolean = false,
    var isFooter: Boolean = false,
    var isRekapCust: Boolean = false,
    var isRekapChannel: Boolean = false,
    var isRekapFaktur: Boolean = false,
    var isRekapItem: Boolean = false,
    var isRekapItemChannel: Boolean = false,
    var filePath: String = "",
    var header: String = "",
    var footer: String = "",

)