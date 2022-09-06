package com.bits.bee.bpmc.presentation.ui.pos.addon

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class AddOnFragmentArgs(
  public val item: Item,
  public val bp: Bp,
  public val priceLvlId: Int = 1,
  public val saled: Saled? = null
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Item::class.java)) {
      result.putParcelable("item", this.item as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Item::class.java)) {
      result.putSerializable("item", this.item as Serializable)
    } else {
      throw UnsupportedOperationException(Item::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    if (Parcelable::class.java.isAssignableFrom(Bp::class.java)) {
      result.putParcelable("bp", this.bp as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Bp::class.java)) {
      result.putSerializable("bp", this.bp as Serializable)
    } else {
      throw UnsupportedOperationException(Bp::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    result.putInt("priceLvlId", this.priceLvlId)
    if (Parcelable::class.java.isAssignableFrom(Saled::class.java)) {
      result.putParcelable("saled", this.saled as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Saled::class.java)) {
      result.putSerializable("saled", this.saled as Serializable?)
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Item::class.java)) {
      result.set("item", this.item as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Item::class.java)) {
      result.set("item", this.item as Serializable)
    } else {
      throw UnsupportedOperationException(Item::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    if (Parcelable::class.java.isAssignableFrom(Bp::class.java)) {
      result.set("bp", this.bp as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Bp::class.java)) {
      result.set("bp", this.bp as Serializable)
    } else {
      throw UnsupportedOperationException(Bp::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    result.set("priceLvlId", this.priceLvlId)
    if (Parcelable::class.java.isAssignableFrom(Saled::class.java)) {
      result.set("saled", this.saled as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Saled::class.java)) {
      result.set("saled", this.saled as Serializable?)
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): AddOnFragmentArgs {
      bundle.setClassLoader(AddOnFragmentArgs::class.java.classLoader)
      val __item : Item?
      if (bundle.containsKey("item")) {
        if (Parcelable::class.java.isAssignableFrom(Item::class.java) ||
            Serializable::class.java.isAssignableFrom(Item::class.java)) {
          __item = bundle.get("item") as Item?
        } else {
          throw UnsupportedOperationException(Item::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__item == null) {
          throw IllegalArgumentException("Argument \"item\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"item\" is missing and does not have an android:defaultValue")
      }
      val __bp : Bp?
      if (bundle.containsKey("bp")) {
        if (Parcelable::class.java.isAssignableFrom(Bp::class.java) ||
            Serializable::class.java.isAssignableFrom(Bp::class.java)) {
          __bp = bundle.get("bp") as Bp?
        } else {
          throw UnsupportedOperationException(Bp::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__bp == null) {
          throw IllegalArgumentException("Argument \"bp\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"bp\" is missing and does not have an android:defaultValue")
      }
      val __priceLvlId : Int
      if (bundle.containsKey("priceLvlId")) {
        __priceLvlId = bundle.getInt("priceLvlId")
      } else {
        __priceLvlId = 1
      }
      val __saled : Saled?
      if (bundle.containsKey("saled")) {
        if (Parcelable::class.java.isAssignableFrom(Saled::class.java) ||
            Serializable::class.java.isAssignableFrom(Saled::class.java)) {
          __saled = bundle.get("saled") as Saled?
        } else {
          throw UnsupportedOperationException(Saled::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __saled = null
      }
      return AddOnFragmentArgs(__item, __bp, __priceLvlId, __saled)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): AddOnFragmentArgs {
      val __item : Item?
      if (savedStateHandle.contains("item")) {
        if (Parcelable::class.java.isAssignableFrom(Item::class.java) ||
            Serializable::class.java.isAssignableFrom(Item::class.java)) {
          __item = savedStateHandle.get<Item?>("item")
        } else {
          throw UnsupportedOperationException(Item::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__item == null) {
          throw IllegalArgumentException("Argument \"item\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"item\" is missing and does not have an android:defaultValue")
      }
      val __bp : Bp?
      if (savedStateHandle.contains("bp")) {
        if (Parcelable::class.java.isAssignableFrom(Bp::class.java) ||
            Serializable::class.java.isAssignableFrom(Bp::class.java)) {
          __bp = savedStateHandle.get<Bp?>("bp")
        } else {
          throw UnsupportedOperationException(Bp::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__bp == null) {
          throw IllegalArgumentException("Argument \"bp\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"bp\" is missing and does not have an android:defaultValue")
      }
      val __priceLvlId : Int?
      if (savedStateHandle.contains("priceLvlId")) {
        __priceLvlId = savedStateHandle["priceLvlId"]
        if (__priceLvlId == null) {
          throw IllegalArgumentException("Argument \"priceLvlId\" of type integer does not support null values")
        }
      } else {
        __priceLvlId = 1
      }
      val __saled : Saled?
      if (savedStateHandle.contains("saled")) {
        if (Parcelable::class.java.isAssignableFrom(Saled::class.java) ||
            Serializable::class.java.isAssignableFrom(Saled::class.java)) {
          __saled = savedStateHandle.get<Saled?>("saled")
        } else {
          throw UnsupportedOperationException(Saled::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __saled = null
      }
      return AddOnFragmentArgs(__item, __bp, __priceLvlId, __saled)
    }
  }
}
