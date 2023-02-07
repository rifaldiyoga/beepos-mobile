package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
import java.util.*

@Parcelize
data class LineChartData(
    var qty: BigDecimal? = null,
    var date: Date? = null
): Parcelable