package com.bits.bee.bpmc.presentation.ui.pilih_db

import android.os.Bundle
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import kotlin.Int
import kotlin.String

public class PilihDbFragmentDirections private constructor() {
  private data class ActionPilihDbFragmentToModeTampilanFragment(
    public val type: String = "signin"
  ) : NavDirections {
    public override val actionId: Int = R.id.action_pilihDbFragment_to_modeTampilanFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  public companion object {
    public fun actionPilihDbFragmentToModeTampilanFragment(type: String = "signin"): NavDirections =
        ActionPilihDbFragmentToModeTampilanFragment(type)
  }
}
