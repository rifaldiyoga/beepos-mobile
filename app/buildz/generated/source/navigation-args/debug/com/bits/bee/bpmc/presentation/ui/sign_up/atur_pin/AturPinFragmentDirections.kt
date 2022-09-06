package com.bits.bee.bpmc.presentation.ui.sign_up.atur_pin

import android.os.Bundle
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import kotlin.Int
import kotlin.String

public class AturPinFragmentDirections private constructor() {
  private data class ActionAturPinFragmentToUlangiPinFragment(
    public val pin: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_aturPinFragment_to_ulangiPinFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("pin", this.pin)
        return result
      }
  }

  public companion object {
    public fun actionAturPinFragmentToUlangiPinFragment(pin: String): NavDirections =
        ActionAturPinFragmentToUlangiPinFragment(pin)
  }
}
