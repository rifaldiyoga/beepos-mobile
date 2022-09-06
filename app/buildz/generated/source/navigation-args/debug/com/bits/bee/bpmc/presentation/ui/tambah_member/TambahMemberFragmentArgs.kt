package com.bits.bee.bpmc.presentation.ui.tambah_member

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class TambahMemberFragmentArgs(
  public val district: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("district", this.district)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("district", this.district)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): TambahMemberFragmentArgs {
      bundle.setClassLoader(TambahMemberFragmentArgs::class.java.classLoader)
      val __district : String?
      if (bundle.containsKey("district")) {
        __district = bundle.getString("district")
        if (__district == null) {
          throw IllegalArgumentException("Argument \"district\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"district\" is missing and does not have an android:defaultValue")
      }
      return TambahMemberFragmentArgs(__district)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): TambahMemberFragmentArgs {
      val __district : String?
      if (savedStateHandle.contains("district")) {
        __district = savedStateHandle["district"]
        if (__district == null) {
          throw IllegalArgumentException("Argument \"district\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"district\" is missing and does not have an android:defaultValue")
      }
      return TambahMemberFragmentArgs(__district)
    }
  }
}
