package com.bits.bee.bpmc.presentation.ui.lainnya

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class LainnyaFragmentDirections private constructor() {
  public companion object {
    public fun actionLainnyaFragmentToSettingListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_lainnyaFragment_to_settingListFragment)

    public fun actionLainnyaFragmentToUploadManualFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_lainnyaFragment_to_uploadManualFragment)

    public fun actionLainnyaFragmentToRekapKasFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_lainnyaFragment_to_rekapKasFragment)

    public fun actionLainnyaFragmentToRekapProdukFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_lainnyaFragment_to_rekapProdukFragment)

    public fun actionLainnyaFragmentToCekStokFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_lainnyaFragment_to_cekStokFragment)

    public fun actionLainnyaFragmentToKelolaProdukFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_lainnyaFragment_to_kelolaProdukFragment)

    public fun actionLainnyaFragmentToDownloadActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_lainnyaFragment_to_downloadActivity)
  }
}
