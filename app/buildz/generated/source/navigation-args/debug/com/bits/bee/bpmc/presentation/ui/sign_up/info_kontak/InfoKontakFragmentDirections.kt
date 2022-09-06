package com.bits.bee.bpmc.presentation.ui.sign_up.info_kontak

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.domain.model.SignUp
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class InfoKontakFragmentDirections private constructor() {
  private data class ActionInfoKontakFragmentToOtpFragment(
    public val signUp: SignUp
  ) : NavDirections {
    public override val actionId: Int = R.id.action_infoKontakFragment_to_otpFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(SignUp::class.java)) {
          result.putParcelable("signUp", this.signUp as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(SignUp::class.java)) {
          result.putSerializable("signUp", this.signUp as Serializable)
        } else {
          throw UnsupportedOperationException(SignUp::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  private data class ActionInfoKontakFragmentToInfoBisnisFragment(
    public val signUp: SignUp
  ) : NavDirections {
    public override val actionId: Int = R.id.action_infoKontakFragment_to_infoBisnisFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(SignUp::class.java)) {
          result.putParcelable("signUp", this.signUp as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(SignUp::class.java)) {
          result.putSerializable("signUp", this.signUp as Serializable)
        } else {
          throw UnsupportedOperationException(SignUp::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionInfoKontakFragmentToOtpFragment(signUp: SignUp): NavDirections =
        ActionInfoKontakFragmentToOtpFragment(signUp)

    public fun actionInfoKontakFragmentToInfoBisnisFragment(signUp: SignUp): NavDirections =
        ActionInfoKontakFragmentToInfoBisnisFragment(signUp)
  }
}
