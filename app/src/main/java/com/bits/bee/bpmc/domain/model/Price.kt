package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 12/05/22.
 */
@Parcelize
data class Price (
    var id : Int,
    var itemId : Int,
    var priceLvlId: Int,
    var crcId: Int,
    var price : BigDecimal,
    var discExp : String?,
    var crcSymbol : String,
) : Parcelable