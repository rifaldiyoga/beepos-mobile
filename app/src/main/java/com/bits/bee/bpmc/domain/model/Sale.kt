package com.bits.bee.bpmc.domain.model

import java.math.BigDecimal

/**
 * Created by aldi on 20/05/22.
 */
data class Sale (
    var id : Int? = null,
    var trxOrderNum : Int = -1,
    var trxNo : String = "",
    var isDraft : Boolean = false,
    var subtotal : BigDecimal = BigDecimal.ZERO,
    var total : BigDecimal = BigDecimal.ZERO,
    var oprName: String = "",
    var cashiername : String = "",
    var trxDate : Long = -1,
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
)