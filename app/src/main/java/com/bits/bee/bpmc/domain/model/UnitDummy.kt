package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 12/05/22.
 */
@Parcelize
data class UnitDummy (
    var id : Int? = null ,
    var itemId : Int = -1,
    var idx: Int = -1,
    var unit: String = "",
    var conv : BigDecimal = BigDecimal.ONE,
) : Parcelable