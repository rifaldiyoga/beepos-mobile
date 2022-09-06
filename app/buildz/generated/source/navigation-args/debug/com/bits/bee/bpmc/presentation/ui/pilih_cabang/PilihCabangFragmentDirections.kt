package com.bits.bee.bpmc.presentation.ui.pilih_cabang

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class PilihCabangFragmentDirections private constructor() {
  public companion object {
    public fun actionPilihCabangFragmentToPilihKasirFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_pilihCabangFragment_to_pilihKasirFragment)
  }
}
