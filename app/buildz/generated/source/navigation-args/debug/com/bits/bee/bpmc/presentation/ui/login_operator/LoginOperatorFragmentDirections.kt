package com.bits.bee.bpmc.presentation.ui.login_operator

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class LoginOperatorFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginOperatorFragmentToHomeActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginOperatorFragment_to_homeActivity)
  }
}
