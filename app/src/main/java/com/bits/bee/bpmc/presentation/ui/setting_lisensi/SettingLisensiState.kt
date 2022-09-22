package com.bits.bee.bpmc.presentation.ui.setting_lisensi

import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.License

data class SettingLisensiState(
    var lisensi: License? = null,
    var cashier: Cashier? = null
)