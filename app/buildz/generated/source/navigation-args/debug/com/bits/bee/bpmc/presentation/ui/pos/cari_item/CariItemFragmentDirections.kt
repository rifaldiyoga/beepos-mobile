package com.bits.bee.bpmc.presentation.ui.pos.cari_item

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.model.Stock
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class CariItemFragmentDirections private constructor() {
  private data class ActionCariItemFragmentToEditItemDialog(
    public val saled: Saled? = null,
    public val item: Item? = null,
    public val pid: Stock? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_cariItemFragment_to_editItemDialog

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  private data class ActionCariItemFragmentToPilihPidFragment(
    public val item: Item
  ) : NavDirections {
    public override val actionId: Int = R.id.action_cariItemFragment_to_pilihPidFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Item::class.java)) {
          result.putParcelable("item", this.item as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Item::class.java)) {
          result.putSerializable("item", this.item as Serializable)
        } else {
          throw UnsupportedOperationException(Item::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionCariItemFragmentToScannerFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_cariItemFragment_to_scannerFragment)

    public fun actionCariItemFragmentToEditItemDialog(
      saled: Saled? = null,
      item: Item? = null,
      pid: Stock? = null
    ): NavDirections = ActionCariItemFragmentToEditItemDialog(saled, item, pid)

    public fun actionCariItemFragmentToPilihPidFragment(item: Item): NavDirections =
        ActionCariItemFragmentToPilihPidFragment(item)
  }
}
