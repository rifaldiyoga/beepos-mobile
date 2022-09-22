package com.bits.bee.bpmc.presentation.ui.setting_pos

/**
 * Created by aldi on 05/04/22.
 */
data class SettingPosViewState(
    var ukuranFont : String = "",
    var isMultiLine : Boolean = false,
    var isKonfirmasiCustomer : Boolean = false,
    var customer : String? = null,
    var jumlahMeja : String? = null,
    var presetBukaKasir : String? = null,
    var isMuatGambar : Boolean = false,
    var orientation : String = ""
)