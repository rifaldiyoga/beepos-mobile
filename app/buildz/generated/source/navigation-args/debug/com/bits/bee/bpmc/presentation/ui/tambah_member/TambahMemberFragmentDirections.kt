package com.bits.bee.bpmc.presentation.ui.tambah_member

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class TambahMemberFragmentDirections private constructor() {
  public companion object {
    public fun actionTambahMemberFragmentToTaxInfoDialog(): NavDirections =
        ActionOnlyNavDirections(R.id.action_tambahMemberFragment_to_taxInfoDialog)

    public fun actionTambahMemberFragmentToCariKotaFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_tambahMemberFragment_to_cariKotaFragment)

    public fun actionTambahMemberFragmentToMemberFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_tambahMemberFragment_to_memberFragment)
  }
}
