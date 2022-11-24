package com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin

/**
 * Created by aldi on 30/08/22.
 */
data class UlangiPinState(
    var pinBefore : String = "",
    var pin : String = "",
    var email : String = "",
    var password : String = "",
    var authKey : String = ""
)