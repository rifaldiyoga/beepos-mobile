package com.bits.bee.bpmc.presentation.ui.mode_tampilan

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class ModeTampilanFragmentArgs(
  public val type: String = "signin"
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("type", this.type)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("type", this.type)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ModeTampilanFragmentArgs {
      bundle.setClassLoader(ModeTampilanFragmentArgs::class.java.classLoader)
      val __type : String?
      if (bundle.containsKey("type")) {
        __type = bundle.getString("type")
        if (__type == null) {
          throw IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value.")
        }
      } else {
        __type = "signin"
      }
      return ModeTampilanFragmentArgs(__type)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): ModeTampilanFragmentArgs {
      val __type : String?
      if (savedStateHandle.contains("type")) {
        __type = savedStateHandle["type"]
        if (__type == null) {
          throw IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value")
        }
      } else {
        __type = "signin"
      }
      return ModeTampilanFragmentArgs(__type)
    }
  }
}
