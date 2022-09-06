package com.bits.bee.bpmc.presentation.ui.pos.edit_item

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.model.Stock
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class EditItemFragmentArgs(
  public val saled: Saled? = null,
  public val item: Item? = null,
  public val pid: Stock? = null
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Saled::class.java)) {
      result.putParcelable("saled", this.saled as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Saled::class.java)) {
      result.putSerializable("saled", this.saled as Serializable?)
    }
    if (Parcelable::class.java.isAssignableFrom(Item::class.java)) {
      result.putParcelable("item", this.item as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Item::class.java)) {
      result.putSerializable("item", this.item as Serializable?)
    }
    if (Parcelable::class.java.isAssignableFrom(Stock::class.java)) {
      result.putParcelable("pid", this.pid as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Stock::class.java)) {
      result.putSerializable("pid", this.pid as Serializable?)
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Saled::class.java)) {
      result.set("saled", this.saled as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Saled::class.java)) {
      result.set("saled", this.saled as Serializable?)
    }
    if (Parcelable::class.java.isAssignableFrom(Item::class.java)) {
      result.set("item", this.item as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Item::class.java)) {
      result.set("item", this.item as Serializable?)
    }
    if (Parcelable::class.java.isAssignableFrom(Stock::class.java)) {
      result.set("pid", this.pid as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Stock::class.java)) {
      result.set("pid", this.pid as Serializable?)
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): EditItemFragmentArgs {
      bundle.setClassLoader(EditItemFragmentArgs::class.java.classLoader)
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
      val __item : Item?
      if (bundle.containsKey("item")) {
        if (Parcelable::class.java.isAssignableFrom(Item::class.java) ||
            Serializable::class.java.isAssignableFrom(Item::class.java)) {
          __item = bundle.get("item") as Item?
        } else {
          throw UnsupportedOperationException(Item::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __item = null
      }
      val __pid : Stock?
      if (bundle.containsKey("pid")) {
        if (Parcelable::class.java.isAssignableFrom(Stock::class.java) ||
            Serializable::class.java.isAssignableFrom(Stock::class.java)) {
          __pid = bundle.get("pid") as Stock?
        } else {
          throw UnsupportedOperationException(Stock::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __pid = null
      }
      return EditItemFragmentArgs(__saled, __item, __pid)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): EditItemFragmentArgs {
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
      val __item : Item?
      if (savedStateHandle.contains("item")) {
        if (Parcelable::class.java.isAssignableFrom(Item::class.java) ||
            Serializable::class.java.isAssignableFrom(Item::class.java)) {
          __item = savedStateHandle.get<Item?>("item")
        } else {
          throw UnsupportedOperationException(Item::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __item = null
      }
      val __pid : Stock?
      if (savedStateHandle.contains("pid")) {
        if (Parcelable::class.java.isAssignableFrom(Stock::class.java) ||
            Serializable::class.java.isAssignableFrom(Stock::class.java)) {
          __pid = savedStateHandle.get<Stock?>("pid")
        } else {
          throw UnsupportedOperationException(Stock::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __pid = null
      }
      return EditItemFragmentArgs(__saled, __item, __pid)
    }
  }
}
