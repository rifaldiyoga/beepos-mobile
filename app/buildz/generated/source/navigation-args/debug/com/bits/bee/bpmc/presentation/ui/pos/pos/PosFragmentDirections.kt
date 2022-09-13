package com.bits.bee.bpmc.presentation.ui.pos.pos

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.model.Stock
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class PosFragmentDirections private constructor() {
  private data class ActionPosFragmentToEditItemDialog2(
    public val saled: Saled? = null,
    public val item: Item? = null,
    public val pid: Stock? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_posFragment_to_editItemDialog2

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

  private data class ActionPosFragmentToAddOnFragment(
    public val item: Item,
    public val bp: Bp,
    public val priceLvlId: Int = 1,
    public val saled: Saled? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_posFragment_to_addOnFragment

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
  }

  public companion object {
    public fun actionPosFragmentToInvoiceFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_posFragment_to_invoiceFragment)

    public fun actionPosFragmentToMemberFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_posFragment_to_memberFragment)

    public fun actionPosFragmentToDraftListDialog(): NavDirections =
        ActionOnlyNavDirections(R.id.action_posFragment_to_draftListDialog)

    public fun actionPosFragmentToDiskonNotaDialog(): NavDirections =
        ActionOnlyNavDirections(R.id.action_posFragment_to_diskonNotaDialog)

    public fun actionPosFragmentToCariItemFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_posFragment_to_cariItemFragment)

    public fun actionPosFragmentToCariItemFragment2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_posFragment_to_cariItemFragment2)

    public fun actionPosFragmentToEditItemDialog2(
      saled: Saled? = null,
      item: Item? = null,
      pid: Stock? = null
    ): NavDirections = ActionPosFragmentToEditItemDialog2(saled, item, pid)

    public fun actionPosFragmentToAddOnFragment(
      item: Item,
      bp: Bp,
      priceLvlId: Int = 1,
      saled: Saled? = null
    ): NavDirections = ActionPosFragmentToAddOnFragment(item, bp, priceLvlId, saled)

    public fun actionPosFragmentToPromoFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_posFragment_to_promoFragment)
  }
}