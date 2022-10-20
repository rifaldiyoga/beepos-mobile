package com.bits.bee.bpmc.presentation.ui.login_operator

import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.domain.model.Posses

data class LoginOperatorState (
    var email : String = "",
    var password : String = "",
    var messageEmail : String = "",
    var messagePassword : String = "",
    var isValid : Boolean = false,
    var mTimesWrong: Int = 0,
    var mPosses: Posses? = null,
    var mLicense: License? = null,
    var mCashier: Cashier? = null
)