package com.bits.bee.bpmc.presentation.ui.detail_sesi_kasir

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class DetailSesiKasirFragmentArgs(
  public val posses: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("posses", this.posses)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("posses", this.posses)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): DetailSesiKasirFragmentArgs {
      bundle.setClassLoader(DetailSesiKasirFragmentArgs::class.java.classLoader)
      val __posses : String?
      if (bundle.containsKey("posses")) {
        __posses = bundle.getString("posses")
        if (__posses == null) {
          throw IllegalArgumentException("Argument \"posses\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"posses\" is missing and does not have an android:defaultValue")
      }
      return DetailSesiKasirFragmentArgs(__posses)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        DetailSesiKasirFragmentArgs {
      val __posses : String?
      if (savedStateHandle.contains("posses")) {
        __posses = savedStateHandle["posses"]
        if (__posses == null) {
          throw IllegalArgumentException("Argument \"posses\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"posses\" is missing and does not have an android:defaultValue")
      }
      return DetailSesiKasirFragmentArgs(__posses)
    }
  }
}
