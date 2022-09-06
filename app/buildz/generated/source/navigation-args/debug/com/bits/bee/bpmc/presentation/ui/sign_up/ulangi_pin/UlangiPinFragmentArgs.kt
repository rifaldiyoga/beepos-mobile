package com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class UlangiPinFragmentArgs(
  public val pin: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("pin", this.pin)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("pin", this.pin)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): UlangiPinFragmentArgs {
      bundle.setClassLoader(UlangiPinFragmentArgs::class.java.classLoader)
      val __pin : String?
      if (bundle.containsKey("pin")) {
        __pin = bundle.getString("pin")
        if (__pin == null) {
          throw IllegalArgumentException("Argument \"pin\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"pin\" is missing and does not have an android:defaultValue")
      }
      return UlangiPinFragmentArgs(__pin)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): UlangiPinFragmentArgs {
      val __pin : String?
      if (savedStateHandle.contains("pin")) {
        __pin = savedStateHandle["pin"]
        if (__pin == null) {
          throw IllegalArgumentException("Argument \"pin\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"pin\" is missing and does not have an android:defaultValue")
      }
      return UlangiPinFragmentArgs(__pin)
    }
  }
}
