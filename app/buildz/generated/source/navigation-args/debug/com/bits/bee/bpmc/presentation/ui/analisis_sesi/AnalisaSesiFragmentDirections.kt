package com.bits.bee.bpmc.presentation.ui.analisis_sesi

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class AnalisaSesiFragmentDirections private constructor() {
  public companion object {
    public fun actionAnalasisiSesiFragmentToRiwayatSesiFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_analasisiSesiFragment_to_riwayatSesiFragment)

    public fun actionAnalasisiSesiFragmentToDetailBukaKasirFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_analasisiSesiFragment_to_detailBukaKasirFragment)
  }
}
