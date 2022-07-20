package com.bits.bee.bpmc.domain.model

/**
 * Created by aldi on 15/07/22.
 */
data class Tax(
    var id : Int?,
    var code : String,
    var name : String,
    var expr : String,
    var isActive : Boolean,
    var isDefault : Boolean,
)