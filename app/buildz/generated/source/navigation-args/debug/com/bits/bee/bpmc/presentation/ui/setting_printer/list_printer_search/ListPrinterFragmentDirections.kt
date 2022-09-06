package com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search

import android.os.Bundle
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public class ListPrinterFragmentDirections private constructor() {
  private data class ActionListPrinterFragmentToAddPrinterFragment(
    public val isNew: Boolean,
    public val printer: String?
  ) : NavDirections {
    public override val actionId: Int = R.id.action_listPrinterFragment_to_addPrinterFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putBoolean("isNew", this.isNew)
        result.putString("printer", this.printer)
        return result
      }
  }

  public companion object {
    public fun actionListPrinterFragmentToAddPrinterFragment(isNew: Boolean, printer: String?):
        NavDirections = ActionListPrinterFragmentToAddPrinterFragment(isNew, printer)
  }
}
