package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.CashAEntity
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class CashA(
    var id : Int? = null,
    var trxDate : String,
    var amount: BigDecimal,
    var note: String,
    var inOut : String,
    var refType : String,
    var refId : Long,
    var autoGen : Boolean,
    var cashId: Int,
    var userId: Int,
    var cashierId: Int
): Parcelable