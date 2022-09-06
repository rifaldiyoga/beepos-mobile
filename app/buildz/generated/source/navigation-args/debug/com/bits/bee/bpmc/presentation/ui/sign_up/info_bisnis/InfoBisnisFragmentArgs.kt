package com.bits.bee.bpmc.presentation.ui.sign_up.info_bisnis

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.bits.bee.bpmc.domain.model.SignUp
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class InfoBisnisFragmentArgs(
  public val signUp: SignUp
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(SignUp::class.java)) {
      result.set("signUp", this.signUp as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(SignUp::class.java)) {
      result.set("signUp", this.signUp as Serializable)
    } else {
      throw UnsupportedOperationException(SignUp::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): InfoBisnisFragmentArgs {
      bundle.setClassLoader(InfoBisnisFragmentArgs::class.java.classLoader)
      val __signUp : SignUp?
      if (bundle.containsKey("signUp")) {
        if (Parcelable::class.java.isAssignableFrom(SignUp::class.java) ||
            Serializable::class.java.isAssignableFrom(SignUp::class.java)) {
          __signUp = bundle.get("signUp") as SignUp?
        } else {
          throw UnsupportedOperationException(SignUp::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__signUp == null) {
          throw IllegalArgumentException("Argument \"signUp\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"signUp\" is missing and does not have an android:defaultValue")
      }
      return InfoBisnisFragmentArgs(__signUp)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): InfoBisnisFragmentArgs {
      val __signUp : SignUp?
      if (savedStateHandle.contains("signUp")) {
        if (Parcelable::class.java.isAssignableFrom(SignUp::class.java) ||
            Serializable::class.java.isAssignableFrom(SignUp::class.java)) {
          __signUp = savedStateHandle.get<SignUp?>("signUp")
        } else {
          throw UnsupportedOperationException(SignUp::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__signUp == null) {
          throw IllegalArgumentException("Argument \"signUp\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"signUp\" is missing and does not have an android:defaultValue")
      }
      return InfoBisnisFragmentArgs(__signUp)
    }
  }
}
