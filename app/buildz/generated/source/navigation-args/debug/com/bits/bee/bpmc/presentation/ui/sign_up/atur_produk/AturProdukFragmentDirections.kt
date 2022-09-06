package com.bits.bee.bpmc.presentation.ui.sign_up.atur_produk

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class AturProdukFragmentDirections private constructor() {
  public companion object {
    public fun actionAturProdukFragmentToTambahProdukFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_aturProdukFragment_to_tambahProdukFragment)
  }
}
