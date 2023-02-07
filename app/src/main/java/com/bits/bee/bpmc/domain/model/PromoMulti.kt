package com.bits.bee.bpmc.domain.model

/**
 * Created by aldi on 08/09/22
 */
data class PromoMulti (
    var id : Int?,
    var promoId : Int,
    var type : String,
    var value : String,
    var isReq : Boolean,
    var isDeal : Boolean,
)