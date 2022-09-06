package com.bits.bee.bpmc.presentation.ui.pembayaran

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class PembayaranFragmentDirections private constructor() {
  public companion object {
    public fun actionPembayaranFragmentToPembayaranNonTunaiFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_pembayaranFragment_to_pembayaranNonTunaiFragment)

    public fun actionPembayaranFragmentToTransaksiBerhasilFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_pembayaranFragment_to_transaksiBerhasilFragment)
  }
}
