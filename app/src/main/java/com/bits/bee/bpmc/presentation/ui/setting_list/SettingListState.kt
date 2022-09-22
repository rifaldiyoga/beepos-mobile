package com.bits.bee.bpmc.presentation.ui.setting_list

import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.User

data class SettingListState(
    var mUser: User? = null,
    var mCashier: Cashier? = null
)