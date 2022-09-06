package com.bits.bee.bpmc.presentation.ui.transaksi_berhasil

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class TransaksiBerhasilFragmentDirections private constructor() {
  public companion object {
    public fun actionTransaksiBerhasilFragmentToPosFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_transaksiBerhasilFragment_to_posFragment)
  }
}
