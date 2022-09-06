package com.bits.bee.bpmc.presentation.dialog.detail_member

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.bits.bee.bpmc.domain.model.Bp
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class DetailMemberDialogArgs(
  public val member: Bp
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Bp::class.java)) {
      result.putParcelable("member", this.member as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Bp::class.java)) {
      result.putSerializable("member", this.member as Serializable)
    } else {
      throw UnsupportedOperationException(Bp::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Bp::class.java)) {
      result.set("member", this.member as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Bp::class.java)) {
      result.set("member", this.member as Serializable)
    } else {
      throw UnsupportedOperationException(Bp::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): DetailMemberDialogArgs {
      bundle.setClassLoader(DetailMemberDialogArgs::class.java.classLoader)
      val __member : Bp?
      if (bundle.containsKey("member")) {
        if (Parcelable::class.java.isAssignableFrom(Bp::class.java) ||
            Serializable::class.java.isAssignableFrom(Bp::class.java)) {
          __member = bundle.get("member") as Bp?
        } else {
          throw UnsupportedOperationException(Bp::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__member == null) {
          throw IllegalArgumentException("Argument \"member\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"member\" is missing and does not have an android:defaultValue")
      }
      return DetailMemberDialogArgs(__member)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetailMemberDialogArgs {
      val __member : Bp?
      if (savedStateHandle.contains("member")) {
        if (Parcelable::class.java.isAssignableFrom(Bp::class.java) ||
            Serializable::class.java.isAssignableFrom(Bp::class.java)) {
          __member = savedStateHandle.get<Bp?>("member")
        } else {
          throw UnsupportedOperationException(Bp::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__member == null) {
          throw IllegalArgumentException("Argument \"member\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"member\" is missing and does not have an android:defaultValue")
      }
      return DetailMemberDialogArgs(__member)
    }
  }
}
