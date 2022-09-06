package com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir

import android.os.Bundle
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import kotlin.Int
import kotlin.String

public class RekapSesiFragmentDirections private constructor() {
  private data class ActionRekapSesiFragmentToDetailSesiKasirFragment(
    public val posses: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_rekapSesiFragment_to_detailSesiKasirFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("posses", this.posses)
        return result
      }
  }

  public companion object {
    public fun actionRekapSesiFragmentToDetailSesiKasirFragment(posses: String): NavDirections =
        ActionRekapSesiFragmentToDetailSesiKasirFragment(posses)
  }
}
