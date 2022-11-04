package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 10/08/22.
 */
@Parcelize
data class ItemWithUnit (
    var item: Item,
    var unit : Unit? = null,
    var pid : String? = null,
    var stock : Stock? = null,
    var discExp : String = "",
    var discAmt : BigDecimal = BigDecimal.ZERO,
    var note : String = ""
) : Parcelable