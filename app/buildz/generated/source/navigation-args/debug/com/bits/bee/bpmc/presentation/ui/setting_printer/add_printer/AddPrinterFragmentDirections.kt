package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class AddPrinterFragmentDirections private constructor() {
  public companion object {
    public fun actionAddPrinterFragmentToListPrinterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addPrinterFragment_to_listPrinterFragment)

    public fun actionAddPrinterFragmentToSettingPrinterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addPrinterFragment_to_settingPrinterFragment)
  }
}
