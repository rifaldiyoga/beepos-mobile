package com.bits.bee.bpmc.presentation.ui.setting_pos

/**
 * Created by aldi on 05/04/22.
 */
data class SettingPosViewState(
    var ukuranFont : String = "",
    var isMultiFont : Boolean = false,
    var isKonfirmasiCustomer : Boolean = false,
    var customer : String? = null,
    var jumlahMeja : Int? = null,
    var presetBukaKasir : Double = 0.0,
    var isMuatGambarProduk : Boolean = false,
    var isRekapPerCustomer : Boolean = false,
    var isRekapPerProdukChannel : Boolean = false,
    var isRekapPerFaktur : Boolean = false,
    var isRekapPerChannel : Boolean = false,
    var orientation : String = ""
)