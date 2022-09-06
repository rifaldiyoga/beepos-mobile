package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 12/05/22.
 */
@Parcelize
data class UnitDummy (
    var id : Int,
    var itemId : Int,
    var idx: Int,
    var unit: String,
    var conv : BigDecimal,
) : Parcelable