package com.bits.bee.bpmc.presentation.ui.setting_sistem

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class SettingSistemFragmentDirections private constructor() {
  public companion object {
    public fun actionSettingSistemFragmentToSettingPrinterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settingSistemFragment_to_settingPrinterFragment)
  }
}
