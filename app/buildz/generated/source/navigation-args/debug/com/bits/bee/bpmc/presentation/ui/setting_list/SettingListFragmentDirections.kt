package com.bits.bee.bpmc.presentation.ui.setting_list

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class SettingListFragmentDirections private constructor() {
  public companion object {
    public fun actionSettingListFragmentToSettingPosFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settingListFragment_to_settingPosFragment)

    public fun actionSettingListFragmentToSettingSistemFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settingListFragment_to_settingSistemFragment)

    public fun actionSettingListFragmentToSettingNotaFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settingListFragment_to_settingNotaFragment)

    public fun actionSettingListFragmentToSettingFavoriteFragmentMain(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settingListFragment_to_settingFavoriteFragmentMain)

    public fun actionSettingListFragmentToHelpLicenseFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settingListFragment_to_helpLicenseFragment)

    public fun actionSettingListFragmentToSettingPrinterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settingListFragment_to_settingPrinterFragment)
  }
}
