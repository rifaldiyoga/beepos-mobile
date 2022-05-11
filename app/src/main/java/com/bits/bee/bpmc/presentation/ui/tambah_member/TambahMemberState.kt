package com.bits.bee.bpmc.presentation.ui.tambah_member

/**
 * Created by aldi on 27/04/22.
 */
data class TambahMemberState (
    var namaMember : String = "",
    var noTelp : String = "",
    var alamat : String = "",
    var isTaxed : Boolean = false,
    var isTaxInc : Boolean = false,
    var kota : String = "",
    var email : String = "",
    var priceLvl : Int = -1,
    var isInfoLainnya : Boolean = false,
    var errorNamaMember : String = "",
    var errorNoTelp : String = "",
    var errorAlamat : String = "",
    var errorEmail : String = "",
)