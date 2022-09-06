package com.bits.bee.bpmc.presentation.ui.cari_kota

import android.os.Bundle
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import kotlin.Int
import kotlin.String

public class CariKotaFragmentDirections private constructor() {
  private data class ActionCariKotaFragmentToCariKecamatanFragment(
    public val regency: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_cariKotaFragment_to_cariKecamatanFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("regency", this.regency)
        return result
      }
  }

  public companion object {
    public fun actionCariKotaFragmentToCariKecamatanFragment(regency: String): NavDirections =
        ActionCariKotaFragmentToCariKecamatanFragment(regency)
  }
}
