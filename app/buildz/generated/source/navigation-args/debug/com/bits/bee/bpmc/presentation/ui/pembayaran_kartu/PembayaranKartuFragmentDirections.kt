package com.bits.bee.bpmc.presentation.ui.pembayaran_kartu

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class PembayaranKartuFragmentDirections private constructor() {
  public companion object {
    public fun actionPembayaranDebitKreditFragmentToTransaksiBerhasilFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_pembayaranDebitKreditFragment_to_transaksiBerhasilFragment)
  }
}
