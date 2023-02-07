package com.bits.bee.bpmc.presentation.ui.setting_sistem

data class SettingSistemState (
    var sistemPenyimpanan: String="",
    var sistemBatchUpload: String = "",
    var periodeUploadOtomatis: String ="",
    var aboutCloudDapur: String ="",
    var isCloudDapur: Boolean = false
)