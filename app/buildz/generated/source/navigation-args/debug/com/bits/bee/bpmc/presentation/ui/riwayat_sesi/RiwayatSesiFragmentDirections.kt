package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import android.os.Bundle
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import kotlin.Int
import kotlin.String

public class RiwayatSesiFragmentDirections private constructor() {
  private data class ActionRiwayatSesiFragmentToDetailRiwayatSesiFragment(
    public val posses: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_riwayatSesiFragment_to_detailRiwayatSesiFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("posses", this.posses)
        return result
      }
  }

  public companion object {
    public fun actionRiwayatSesiFragmentToDetailRiwayatSesiFragment(posses: String): NavDirections =
        ActionRiwayatSesiFragmentToDetailRiwayatSesiFragment(posses)
  }
}
