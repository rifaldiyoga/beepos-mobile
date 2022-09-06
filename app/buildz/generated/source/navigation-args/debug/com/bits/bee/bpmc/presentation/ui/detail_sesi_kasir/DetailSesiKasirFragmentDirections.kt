package com.bits.bee.bpmc.presentation.ui.detail_sesi_kasir

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class DetailSesiKasirFragmentDirections private constructor() {
  public companion object {
    public fun actionDetailSesiKasirFragmentToDetailPendapatanDialog(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detailSesiKasirFragment_to_detailPendapatanDialog)
  }
}
