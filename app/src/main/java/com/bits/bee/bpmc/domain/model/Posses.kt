package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
import java.util.*

/**
 * Created by aldi on 07/06/22.
 */
@Parcelize
data class Posses (
    var possesId : Int? = null,
    var trxDate : Date,
    var startTime : Date,
    var endTime : Date? = null,
    var startBal : BigDecimal,
    var endBal : BigDecimal? = null,
    var total: BigDecimal,
    var credit : BigDecimal,
    var shift : Int,
    var operatorId : Int,
    var cashierId: Int,
    var trxNo : String,
    var totIn : BigDecimal? = null,
    var totOut : BigDecimal? = null,
    var endCash : BigDecimal,
    var totalActualCash : BigDecimal,
    var totalDiffCash : BigDecimal,
) : Parcelable