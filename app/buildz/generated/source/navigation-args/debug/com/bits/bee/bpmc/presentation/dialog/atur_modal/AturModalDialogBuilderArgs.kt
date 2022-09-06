package com.bits.bee.bpmc.presentation.dialog.atur_modal

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class AturModalDialogBuilderArgs(
  public val cashier: Cashier,
  public val branch: Branch,
  public val shift: Int
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Cashier::class.java)) {
      result.putParcelable("cashier", this.cashier as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Cashier::class.java)) {
      result.putSerializable("cashier", this.cashier as Serializable)
    } else {
      throw UnsupportedOperationException(Cashier::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    if (Parcelable::class.java.isAssignableFrom(Branch::class.java)) {
      result.putParcelable("branch", this.branch as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Branch::class.java)) {
      result.putSerializable("branch", this.branch as Serializable)
    } else {
      throw UnsupportedOperationException(Branch::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    result.putInt("shift", this.shift)
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Cashier::class.java)) {
      result.set("cashier", this.cashier as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Cashier::class.java)) {
      result.set("cashier", this.cashier as Serializable)
    } else {
      throw UnsupportedOperationException(Cashier::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    if (Parcelable::class.java.isAssignableFrom(Branch::class.java)) {
      result.set("branch", this.branch as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Branch::class.java)) {
      result.set("branch", this.branch as Serializable)
    } else {
      throw UnsupportedOperationException(Branch::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    result.set("shift", this.shift)
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): AturModalDialogBuilderArgs {
      bundle.setClassLoader(AturModalDialogBuilderArgs::class.java.classLoader)
      val __cashier : Cashier?
      if (bundle.containsKey("cashier")) {
        if (Parcelable::class.java.isAssignableFrom(Cashier::class.java) ||
            Serializable::class.java.isAssignableFrom(Cashier::class.java)) {
          __cashier = bundle.get("cashier") as Cashier?
        } else {
          throw UnsupportedOperationException(Cashier::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__cashier == null) {
          throw IllegalArgumentException("Argument \"cashier\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"cashier\" is missing and does not have an android:defaultValue")
      }
      val __branch : Branch?
      if (bundle.containsKey("branch")) {
        if (Parcelable::class.java.isAssignableFrom(Branch::class.java) ||
            Serializable::class.java.isAssignableFrom(Branch::class.java)) {
          __branch = bundle.get("branch") as Branch?
        } else {
          throw UnsupportedOperationException(Branch::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__branch == null) {
          throw IllegalArgumentException("Argument \"branch\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"branch\" is missing and does not have an android:defaultValue")
      }
      val __shift : Int
      if (bundle.containsKey("shift")) {
        __shift = bundle.getInt("shift")
      } else {
        throw IllegalArgumentException("Required argument \"shift\" is missing and does not have an android:defaultValue")
      }
      return AturModalDialogBuilderArgs(__cashier, __branch, __shift)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        AturModalDialogBuilderArgs {
      val __cashier : Cashier?
      if (savedStateHandle.contains("cashier")) {
        if (Parcelable::class.java.isAssignableFrom(Cashier::class.java) ||
            Serializable::class.java.isAssignableFrom(Cashier::class.java)) {
          __cashier = savedStateHandle.get<Cashier?>("cashier")
        } else {
          throw UnsupportedOperationException(Cashier::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__cashier == null) {
          throw IllegalArgumentException("Argument \"cashier\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"cashier\" is missing and does not have an android:defaultValue")
      }
      val __branch : Branch?
      if (savedStateHandle.contains("branch")) {
        if (Parcelable::class.java.isAssignableFrom(Branch::class.java) ||
            Serializable::class.java.isAssignableFrom(Branch::class.java)) {
          __branch = savedStateHandle.get<Branch?>("branch")
        } else {
          throw UnsupportedOperationException(Branch::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__branch == null) {
          throw IllegalArgumentException("Argument \"branch\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"branch\" is missing and does not have an android:defaultValue")
      }
      val __shift : Int?
      if (savedStateHandle.contains("shift")) {
        __shift = savedStateHandle["shift"]
        if (__shift == null) {
          throw IllegalArgumentException("Argument \"shift\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"shift\" is missing and does not have an android:defaultValue")
      }
      return AturModalDialogBuilderArgs(__cashier, __branch, __shift)
    }
  }
}
