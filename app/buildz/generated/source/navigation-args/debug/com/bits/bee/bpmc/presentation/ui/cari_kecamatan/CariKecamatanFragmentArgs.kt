package com.bits.bee.bpmc.presentation.ui.cari_kecamatan

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class CariKecamatanFragmentArgs(
  public val regency: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("regency", this.regency)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("regency", this.regency)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): CariKecamatanFragmentArgs {
      bundle.setClassLoader(CariKecamatanFragmentArgs::class.java.classLoader)
      val __regency : String?
      if (bundle.containsKey("regency")) {
        __regency = bundle.getString("regency")
        if (__regency == null) {
          throw IllegalArgumentException("Argument \"regency\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"regency\" is missing and does not have an android:defaultValue")
      }
      return CariKecamatanFragmentArgs(__regency)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): CariKecamatanFragmentArgs {
      val __regency : String?
      if (savedStateHandle.contains("regency")) {
        __regency = savedStateHandle["regency"]
        if (__regency == null) {
          throw IllegalArgumentException("Argument \"regency\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"regency\" is missing and does not have an android:defaultValue")
      }
      return CariKecamatanFragmentArgs(__regency)
    }
  }
}
