package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
import java.util.*

/**
 * Created by aldi on 30/06/22.
 */
@Parcelize
data class Cstr (
    var id : Int? = null,
    var trxDate : Long,
    var amount1: BigDecimal,
    var amount2: BigDecimal,
    var excrate1 : BigDecimal,
    var excrate2 : BigDecimal,
    var note: Boolean,
    var refType : String,
    var refNo: String,
    var autoGen: String,
    var cashId1 : Long,
    var cashId2 : Long,
    var isUploaded: Boolean,
    var kodeCstr : String,
    var createdAt: Date = Date(),
    var createdBy: Int = -1,
    var updatedAt: Date = Date(),
    var updatedBy: Int = -1,
) : Parcelable