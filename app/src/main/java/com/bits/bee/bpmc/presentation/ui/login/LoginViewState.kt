package com.bits.bee.bpmc.presentation.ui.login

/**
 * Created by aldi on 18/03/22.
 */
data class LoginViewState (
    var email : String = "",
    var password : String = "",
    var messageEmail : String = "",
    var messagePassword : String = "",
    var isValid : Boolean = false
)