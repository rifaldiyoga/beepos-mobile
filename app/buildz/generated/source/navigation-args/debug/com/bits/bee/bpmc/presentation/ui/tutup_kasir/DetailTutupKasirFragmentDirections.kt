package com.bits.bee.bpmc.presentation.ui.tutup_kasir

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class DetailTutupKasirFragmentDirections private constructor() {
  public companion object {
    public fun actionDetailTutupKasirFragmentToMainActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detailTutupKasirFragment_to_mainActivity)

    public fun actionDetailTutupKasirFragmentToRekapSesiFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detailTutupKasirFragment_to_rekapSesiFragment)
  }
}
