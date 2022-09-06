package com.bits.bee.bpmc.presentation.ui.setting_printer

import android.os.Bundle
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public class SettingPrinterFragmentDirections private constructor() {
  private data class ActionSettingPrinterFragmentToAddPrinterFragment(
    public val isNew: Boolean,
    public val printer: String?
  ) : NavDirections {
    public override val actionId: Int = R.id.action_settingPrinterFragment_to_addPrinterFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putBoolean("isNew", this.isNew)
        result.putString("printer", this.printer)
        return result
      }
  }

  public companion object {
    public fun actionSettingPrinterFragmentToAddPrinterFragment(isNew: Boolean, printer: String?):
        NavDirections = ActionSettingPrinterFragmentToAddPrinterFragment(isNew, printer)
  }
}
