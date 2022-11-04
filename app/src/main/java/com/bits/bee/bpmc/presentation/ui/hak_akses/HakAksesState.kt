package com.bits.bee.bpmc.presentation.ui.hak_akses

/**
 * Created by aldi on 01/11/22
 */
data class HakAksesState(
    val acsType : String = "",
    val email : String = "",
    val passwod : String = "",
    var mTimesWrong: Int = 0,
)