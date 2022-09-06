package com.bits.bee.bpmc.presentation.ui.beranda

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class BerandaFragmentDirections private constructor() {
  private data class ActionBerandaFragmentToAturModalDialogBuilder(
    public val cashier: Cashier,
    public val branch: Branch,
    public val shift: Int
  ) : NavDirections {
    public override val actionId: Int = R.id.action_berandaFragment_to_aturModalDialogBuilder

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  public companion object {
    public fun actionBerandaFragmentToDetailTutupKasirFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_berandaFragment_to_detailTutupKasirFragment)

    public fun actionBerandaFragmentToAturModalDialogBuilder(
      cashier: Cashier,
      branch: Branch,
      shift: Int
    ): NavDirections = ActionBerandaFragmentToAturModalDialogBuilder(cashier, branch, shift)

    public fun actionBerandaFragmentToDetailBukaKasirFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_berandaFragment_to_detailBukaKasirFragment)
  }
}
