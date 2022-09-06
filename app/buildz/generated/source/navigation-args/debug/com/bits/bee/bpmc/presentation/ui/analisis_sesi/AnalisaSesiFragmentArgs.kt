package com.bits.bee.bpmc.presentation.ui.analisis_sesi

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Boolean
import kotlin.String
import kotlin.jvm.JvmStatic

public data class AnalisaSesiFragmentArgs(
  public val posses: String,
  public val isRiwayat: Boolean
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("posses", this.posses)
    result.putBoolean("isRiwayat", this.isRiwayat)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("posses", this.posses)
    result.set("isRiwayat", this.isRiwayat)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): AnalisaSesiFragmentArgs {
      bundle.setClassLoader(AnalisaSesiFragmentArgs::class.java.classLoader)
      val __posses : String?
      if (bundle.containsKey("posses")) {
        __posses = bundle.getString("posses")
        if (__posses == null) {
          throw IllegalArgumentException("Argument \"posses\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"posses\" is missing and does not have an android:defaultValue")
      }
      val __isRiwayat : Boolean
      if (bundle.containsKey("isRiwayat")) {
        __isRiwayat = bundle.getBoolean("isRiwayat")
      } else {
        throw IllegalArgumentException("Required argument \"isRiwayat\" is missing and does not have an android:defaultValue")
      }
      return AnalisaSesiFragmentArgs(__posses, __isRiwayat)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): AnalisaSesiFragmentArgs {
      val __posses : String?
      if (savedStateHandle.contains("posses")) {
        __posses = savedStateHandle["posses"]
        if (__posses == null) {
          throw IllegalArgumentException("Argument \"posses\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"posses\" is missing and does not have an android:defaultValue")
      }
      val __isRiwayat : Boolean?
      if (savedStateHandle.contains("isRiwayat")) {
        __isRiwayat = savedStateHandle["isRiwayat"]
        if (__isRiwayat == null) {
          throw IllegalArgumentException("Argument \"isRiwayat\" of type boolean does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"isRiwayat\" is missing and does not have an android:defaultValue")
      }
      return AnalisaSesiFragmentArgs(__posses, __isRiwayat)
    }
  }
}
