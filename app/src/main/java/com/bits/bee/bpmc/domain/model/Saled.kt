package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 20/05/22.
 */
@Parcelize
data class Saled (
    var id : Int? = null,
    var itemId : Int = -1,
    var name : String = "",
    var qty : BigDecimal = BigDecimal.ZERO,
    var listPrice : BigDecimal = BigDecimal.ZERO,
    var disc: BigDecimal = BigDecimal.ZERO,
    var tax : BigDecimal = BigDecimal.ZERO,
    var discExp : String = "",
    var discAmt : BigDecimal = BigDecimal.ZERO,
    var disc2Amt: BigDecimal = BigDecimal.ZERO,
    var taxAmt : BigDecimal = BigDecimal.ZERO,
    var basePrice : BigDecimal = BigDecimal.ZERO,
    var taxableAmt : BigDecimal = BigDecimal.ZERO,
    var subtotal : BigDecimal = BigDecimal.ZERO,
    var saleId: Int = -1,
    var dno : Int = -1,
    var totalDiscAmt : BigDecimal = BigDecimal.ZERO,
    var totalDisc2Amt: BigDecimal = BigDecimal.ZERO,
    var totalTaxAmt : BigDecimal = BigDecimal.ZERO,
    var dNotes: String = "",
    var isBonus : Boolean = false,
    var isBonusUsed : Boolean = false,
    var isDeleted : Boolean = true,
) : Parcelable