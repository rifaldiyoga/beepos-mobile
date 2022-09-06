package com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class PembayaranGopayFragmentDirections private constructor() {
  public companion object {
    public fun actionPembayaranGopayFragmentToTransaksiBerhasilFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_pembayaranGopayFragment_to_transaksiBerhasilFragment)
  }
}
