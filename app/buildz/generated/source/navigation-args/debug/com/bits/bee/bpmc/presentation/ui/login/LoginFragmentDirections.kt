package com.bits.bee.bpmc.presentation.ui.login

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import kotlin.Int
import kotlin.String

public class LoginFragmentDirections private constructor() {
  private data class ActionLoginFragmentToNamaDeviceFragment(
    public val username: String,
    public val password: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_loginFragment_to_namaDeviceFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("username", this.username)
        result.putString("password", this.password)
        return result
      }
  }

  private data class ActionLoginFragmentToModeTampilanFragment(
    public val type: String = "signin"
  ) : NavDirections {
    public override val actionId: Int = R.id.action_loginFragment_to_modeTampilanFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("type", this.type)
        return result
      }
  }

  public companion object {
    public fun actionLoginFragmentToNamaDeviceFragment(username: String, password: String):
        NavDirections = ActionLoginFragmentToNamaDeviceFragment(username, password)

    public fun actionLoginFragmentToModeTampilanFragment(type: String = "signin"): NavDirections =
        ActionLoginFragmentToModeTampilanFragment(type)

    public fun actionLoginFragmentToPilihCabangFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_pilihCabangFragment)

    public fun actionLoginFragmentToPilihKasirFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_pilihKasirFragment)

    public fun actionLoginFragmentToLoginOperatorFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_loginOperatorFragment)

    public fun actionLoginFragmentToModeInfoKontak(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_modeInfoKontak)

    public fun actionLoginFragmentToHomeActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_homeActivity)
  }
}
