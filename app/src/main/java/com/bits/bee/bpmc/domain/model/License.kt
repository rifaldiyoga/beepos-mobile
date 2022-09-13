package com.bits.bee.bpmc.domain.model

import java.util.*

/**
 * Created by aldi on 06/09/22
 */
data class License (
    var name: String,
    var licNumber : String,
    var item : String,
    var licExp : Date,
)