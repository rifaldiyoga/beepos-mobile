package com.bits.bee.bpmc.presentation.ui.mode_tampilan

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class ModeTampilanFragmentDirections private constructor() {
  public companion object {
    public fun actionModeTampilanFragmentToPilihCabangFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_modeTampilanFragment_to_pilihCabangFragment)

    public fun actionModeTampilanFragmentToAturProdukFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_modeTampilanFragment_to_aturProdukFragment)
  }
}
