package com.bits.bee.bpmc.presentation.ui.hak_akses

/**
 * Created by aldi on 01/11/22
 */
data class HakAksesState(
    val acsType : String = "",
    val email : String = "",
    val password : String = "",
    var mTimesWrong: Int = 0,
    var messageEmail : String = "",
    var messagePassword : String = "",
    var isValid : Boolean = false,
)