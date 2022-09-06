package com.bits.bee.bpmc.presentation.ui.detail_transaksi_penjualan

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.bits.bee.bpmc.domain.model.Sale
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class DetailTransaksiPenjualanFragmentArgs(
  public val sale: Sale
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Sale::class.java)) {
      result.putParcelable("sale", this.sale as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Sale::class.java)) {
      result.putSerializable("sale", this.sale as Serializable)
    } else {
      throw UnsupportedOperationException(Sale::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Sale::class.java)) {
      result.set("sale", this.sale as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Sale::class.java)) {
      result.set("sale", this.sale as Serializable)
    } else {
      throw UnsupportedOperationException(Sale::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): DetailTransaksiPenjualanFragmentArgs {
      bundle.setClassLoader(DetailTransaksiPenjualanFragmentArgs::class.java.classLoader)
      val __sale : Sale?
      if (bundle.containsKey("sale")) {
        if (Parcelable::class.java.isAssignableFrom(Sale::class.java) ||
            Serializable::class.java.isAssignableFrom(Sale::class.java)) {
          __sale = bundle.get("sale") as Sale?
        } else {
          throw UnsupportedOperationException(Sale::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__sale == null) {
          throw IllegalArgumentException("Argument \"sale\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"sale\" is missing and does not have an android:defaultValue")
      }
      return DetailTransaksiPenjualanFragmentArgs(__sale)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        DetailTransaksiPenjualanFragmentArgs {
      val __sale : Sale?
      if (savedStateHandle.contains("sale")) {
        if (Parcelable::class.java.isAssignableFrom(Sale::class.java) ||
            Serializable::class.java.isAssignableFrom(Sale::class.java)) {
          __sale = savedStateHandle.get<Sale?>("sale")
        } else {
          throw UnsupportedOperationException(Sale::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__sale == null) {
          throw IllegalArgumentException("Argument \"sale\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"sale\" is missing and does not have an android:defaultValue")
      }
      return DetailTransaksiPenjualanFragmentArgs(__sale)
    }
  }
}
