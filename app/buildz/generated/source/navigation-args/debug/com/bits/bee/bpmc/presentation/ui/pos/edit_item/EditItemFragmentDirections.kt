package com.bits.bee.bpmc.presentation.ui.pos.edit_item

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class EditItemFragmentDirections private constructor() {
  private data class ActionEditItemDialogToAddOnFragment(
    public val item: Item,
    public val bp: Bp,
    public val priceLvlId: Int = 1,
    public val saled: Saled? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_editItemDialog_to_addOnFragment

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
    public fun actionEditItemDialogToAddOnFragment(
      item: Item,
      bp: Bp,
      priceLvlId: Int = 1,
      saled: Saled? = null
    ): NavDirections = ActionEditItemDialogToAddOnFragment(item, bp, priceLvlId, saled)
  }
}
