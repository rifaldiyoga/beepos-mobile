package com.bits.bee.bpmc.presentation.ui.pilih_kasir

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class PilihKasirFragmentDirections private constructor() {
  public companion object {
    public fun actionPilihKasirFragmentToLoginOperatorFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_pilihKasirFragment_to_loginOperatorFragment)
  }
}
