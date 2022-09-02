package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.SalePromoEntity
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class SalePromo(
    var id : Int? = null,
    var saleId: Int,
    var saleNo: String,
    var saledId: Int,
    var promoId: Int,
    var bpId: Int,
    var promoQty: BigDecimal = BigDecimal.ZERO,
    var promoRule : String,
): Parcelable