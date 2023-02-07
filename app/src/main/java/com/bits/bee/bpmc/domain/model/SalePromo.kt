package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.SalePromoEntity
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class SalePromo(
    var id : Int? = null,
    var sale: Sale? = null,
    var saleNo: String? = null,
    var saled: Saled? = null,
    var promo: Promo? = null,
    var bp: Bp? = null,
    var promoQty: BigDecimal = BigDecimal.ZERO,
    var promoRule : String = "",
): Parcelable