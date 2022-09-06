package com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin

import android.os.Bundle
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import kotlin.Int
import kotlin.String

public class UlangiPinFragmentDirections private constructor() {
  private data class ActionUlangiPinFragmentToModeTampilanFragment(
    public val type: String = "signin"
  ) : NavDirections {
    public override val actionId: Int = R.id.action_ulangiPinFragment_to_modeTampilanFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  public companion object {
    public fun actionUlangiPinFragmentToModeTampilanFragment(type: String = "signin"): NavDirections
        = ActionUlangiPinFragmentToModeTampilanFragment(type)
  }
}
