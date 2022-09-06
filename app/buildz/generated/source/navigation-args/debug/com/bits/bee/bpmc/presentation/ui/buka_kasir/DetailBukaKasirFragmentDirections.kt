package com.bits.bee.bpmc.presentation.ui.buka_kasir

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class DetailBukaKasirFragmentDirections private constructor() {
  public companion object {
    public fun actionDetailBukaKasirFragmentToMainActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detailBukaKasirFragment_to_mainActivity)
  }
}
