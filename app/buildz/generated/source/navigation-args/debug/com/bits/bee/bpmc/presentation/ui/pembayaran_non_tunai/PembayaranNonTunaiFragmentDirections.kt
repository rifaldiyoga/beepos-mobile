package com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.domain.model.Pmtd
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class PembayaranNonTunaiFragmentDirections private constructor() {
  private data class ActionPembayaranNonTunaiFragmentToPembayaranDebitKreditFragment(
    public val pmtd: Pmtd
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_pembayaranNonTunaiFragment_to_pembayaranDebitKreditFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  public companion object {
    public fun actionPembayaranNonTunaiFragmentToPembayaranGopayFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_pembayaranNonTunaiFragment_to_pembayaranGopayFragment)

    public fun actionPembayaranNonTunaiFragmentToPembayaranDebitKreditFragment(pmtd: Pmtd):
        NavDirections = ActionPembayaranNonTunaiFragmentToPembayaranDebitKreditFragment(pmtd)
  }
}
