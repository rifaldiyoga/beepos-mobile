package com.bits.bee.bpmc.presentation.ui.cari_kecamatan

import android.os.Bundle
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import kotlin.Int
import kotlin.String

public class CariKecamatanFragmentDirections private constructor() {
  private data class ActionCariKecamatanFragmentToTambahMemberFragment(
    public val district: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_cariKecamatanFragment_to_tambahMemberFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("district", this.district)
        return result
      }
  }

  public companion object {
    public fun actionCariKecamatanFragmentToTambahMemberFragment(district: String): NavDirections =
        ActionCariKecamatanFragmentToTambahMemberFragment(district)
  }
}
