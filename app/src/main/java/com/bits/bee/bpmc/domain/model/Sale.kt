package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.SaleEntity
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
import java.util.*

/**
 * Created by aldi on 20/05/22.
 */
@Parcelize
data class Sale (
    var id : Int? = null,
    var trxOrderNum : Int = -1,
    var trxNo : String = "",
    var isDraft : Boolean = false,
    var subtotal : BigDecimal = BigDecimal.ZERO,
    var total : BigDecimal = BigDecimal.ZERO,
    var userName: String = "",
    var cashiername : String = "",
    var trxDate : Date = Date(),
    var totPaid : BigDecimal = BigDecimal.ZERO,
    var totChange: BigDecimal = BigDecimal.ZERO,
    var taxAmt : BigDecimal = BigDecimal.ZERO,
    var discAmt : BigDecimal = BigDecimal.ZERO,
    var possesId : Int = -1,
    var kodePosses : String = "",
    var discExp : String = "",
    var operatorId: Int = -1,
    var cashierId: Int = -1,
    var bpId: Int = -1,
    var custName : String = "",
    var termType: String = "",
    var isUploaded: Boolean = false,
    var isVoid: Boolean = false,
    var gopayUrl: String = "",
    var gopayTransactionId: String = "",
    var gopayPaymentStatus: String = "",
    var rounding: BigDecimal = BigDecimal.ZERO,
    var channelId: Int = -1,
    var voidNote: String = "",
    var createdAt: Date = Date(),
    var createdBy: Int = -1,
    var updatedAt: Date = Date(),
    var updatedBy: Int = -1,
    var crcId : Int? = -1,
    var crcSymbol : String = "Rp",
    var bp : Bp? = null
) : Parcelable