package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Boolean
import kotlin.String
import kotlin.jvm.JvmStatic

public data class AddPrinterFragmentArgs(
  public val isNew: Boolean,
  public val printer: String?
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putBoolean("isNew", this.isNew)
    result.putString("printer", this.printer)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("isNew", this.isNew)
    result.set("printer", this.printer)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): AddPrinterFragmentArgs {
      bundle.setClassLoader(AddPrinterFragmentArgs::class.java.classLoader)
      val __isNew : Boolean
      if (bundle.containsKey("isNew")) {
        __isNew = bundle.getBoolean("isNew")
      } else {
        throw IllegalArgumentException("Required argument \"isNew\" is missing and does not have an android:defaultValue")
      }
      val __printer : String?
      if (bundle.containsKey("printer")) {
        __printer = bundle.getString("printer")
      } else {
        throw IllegalArgumentException("Required argument \"printer\" is missing and does not have an android:defaultValue")
      }
      return AddPrinterFragmentArgs(__isNew, __printer)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): AddPrinterFragmentArgs {
      val __isNew : Boolean?
      if (savedStateHandle.contains("isNew")) {
        __isNew = savedStateHandle["isNew"]
        if (__isNew == null) {
          throw IllegalArgumentException("Argument \"isNew\" of type boolean does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"isNew\" is missing and does not have an android:defaultValue")
      }
      val __printer : String?
      if (savedStateHandle.contains("printer")) {
        __printer = savedStateHandle["printer"]
      } else {
        throw IllegalArgumentException("Required argument \"printer\" is missing and does not have an android:defaultValue")
      }
      return AddPrinterFragmentArgs(__isNew, __printer)
    }
  }
}
