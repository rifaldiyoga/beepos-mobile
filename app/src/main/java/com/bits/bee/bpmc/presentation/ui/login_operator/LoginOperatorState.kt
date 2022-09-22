package com.bits.bee.bpmc.presentation.ui.login_operator

data class LoginOperatorState (
    var email : String = "",
    var password : String = "",
    var messageEmail : String = "",
    var messagePassword : String = "",
    var isValid : Boolean = false,
    var mTimesWrong: Int = 0
)