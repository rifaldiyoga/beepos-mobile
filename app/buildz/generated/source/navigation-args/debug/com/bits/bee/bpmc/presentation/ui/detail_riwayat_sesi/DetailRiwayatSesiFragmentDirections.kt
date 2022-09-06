package com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public class DetailRiwayatSesiFragmentDirections private constructor() {
  private data class ActionDetailRiwayatSesiFragmentToAnalasisiSesiFragment(
    public val posses: String,
    public val isRiwayat: Boolean
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_detailRiwayatSesiFragment_to_analasisiSesiFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("posses", this.posses)
        result.putBoolean("isRiwayat", this.isRiwayat)
        return result
      }
  }

  public companion object {
    public fun actionDetailRiwayatSesiFragmentToDetailPendapatanDialog(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detailRiwayatSesiFragment_to_detailPendapatanDialog)

    public fun actionDetailRiwayatSesiFragmentToAnalasisiSesiFragment(posses: String,
        isRiwayat: Boolean): NavDirections =
        ActionDetailRiwayatSesiFragmentToAnalasisiSesiFragment(posses, isRiwayat)
  }
}
