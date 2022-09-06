package com.bits.bee.bpmc.presentation.ui.pembayaran_kartu

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.bits.bee.bpmc.domain.model.Pmtd
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class PembayaranKartuFragmentArgs(
  public val pmtd: Pmtd
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Pmtd::class.java)) {
      result.putParcelable("pmtd", this.pmtd as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Pmtd::class.java)) {
      result.putSerializable("pmtd", this.pmtd as Serializable)
    } else {
      throw UnsupportedOperationException(Pmtd::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Pmtd::class.java)) {
      result.set("pmtd", this.pmtd as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Pmtd::class.java)) {
      result.set("pmtd", this.pmtd as Serializable)
    } else {
      throw UnsupportedOperationException(Pmtd::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): PembayaranKartuFragmentArgs {
      bundle.setClassLoader(PembayaranKartuFragmentArgs::class.java.classLoader)
      val __pmtd : Pmtd?
      if (bundle.containsKey("pmtd")) {
        if (Parcelable::class.java.isAssignableFrom(Pmtd::class.java) ||
            Serializable::class.java.isAssignableFrom(Pmtd::class.java)) {
          __pmtd = bundle.get("pmtd") as Pmtd?
        } else {
          throw UnsupportedOperationException(Pmtd::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__pmtd == null) {
          throw IllegalArgumentException("Argument \"pmtd\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"pmtd\" is missing and does not have an android:defaultValue")
      }
      return PembayaranKartuFragmentArgs(__pmtd)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        PembayaranKartuFragmentArgs {
      val __pmtd : Pmtd?
      if (savedStateHandle.contains("pmtd")) {
        if (Parcelable::class.java.isAssignableFrom(Pmtd::class.java) ||
            Serializable::class.java.isAssignableFrom(Pmtd::class.java)) {
          __pmtd = savedStateHandle.get<Pmtd?>("pmtd")
        } else {
          throw UnsupportedOperationException(Pmtd::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__pmtd == null) {
          throw IllegalArgumentException("Argument \"pmtd\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"pmtd\" is missing and does not have an android:defaultValue")
      }
      return PembayaranKartuFragmentArgs(__pmtd)
    }
  }
}
