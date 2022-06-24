package com.bits.bee.bpmc.domain.model

/**
 * Created by aldi on 22/06/22.
 */
data class Operator (
    var id : Int,
    var branchId : Int,
    var cloudLogin : String,
    var operator : String,
    var sandi : String,
    var active : Boolean,
)