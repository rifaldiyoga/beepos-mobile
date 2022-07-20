package com.bits.bee.bpmc.domain.model

/**
 * Created by aldi on 20/07/22.
 */
data class SaleCrcv (
    var id : Int,
    var rcvTypeCode : String,
    var saleInt: Int,
    var rcvAmt : String,
    var note : String,
    var edcId: Int,
    var cashId: Int,
    var cardNo : String,
    var cctypeCode : String,
    var mdrExp : String,
    var mdrAmt : String,
    var surcExp : String,
    var surcAmt : String,
    var mdrAccId : String,
    var surAccId : String,
    var refId : String,
    var trackNo : String,
)