package com.bits.bee.bpmc.presentation.ui.transaksi_penjualan

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.domain.model.Sale
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class TransaksiPenjualanFragmentDirections private constructor() {
  private data class ActionTransaksiPenjualanFragmentToDetailTransaksiPenjualanFragment(
    public val sale: Sale
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_transaksiPenjualanFragment_to_detailTransaksiPenjualanFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  public companion object {
    public fun actionTransaksiPenjualanFragmentToDetailTransaksiPenjualanFragment(sale: Sale):
        NavDirections = ActionTransaksiPenjualanFragmentToDetailTransaksiPenjualanFragment(sale)
  }
}
