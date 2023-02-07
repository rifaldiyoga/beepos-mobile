package com.bits.bee.bpmc.domain.model

/**
 * Created by aldi on 20/07/22.
 */
data class SaleCrcv (
    var id : Int? =null,
    var rcvTypeCode : String,
    var saleInt: Int,
    var rcvAmt : String? = null,
    var note : String,
    var edcId: Int? = null,
    var cashId: Int? = null,
    var cardNo : String? = null,
    var cctypeCode : String? = null,
    var mdrExp : String? = null,
    var mdrAmt : String? = null,
    var surcExp : String? = null,
    var surcAmt : String? = null,
    var mdrAccId : String? = null,
    var surAccId : String? = null,
    var refId : String? = null,
    var trackNo : String? = null,
)