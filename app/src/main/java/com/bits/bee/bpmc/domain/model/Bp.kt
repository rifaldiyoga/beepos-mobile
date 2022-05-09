package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 22/04/22.
 */
@Parcelize
data class Bp(
    var id : Int,
    var code : String,
    var name: String,
    var greeting: String,
    var anniversary : String,
    var isTaxedOnSale : Boolean,
    var isTaxIncOnSale : Boolean,
    var note : String,
    var bpgrpId : Int?,
    var priceLvlId : Int,
    var isActive : Boolean,
//    var createdAt : Date,
//    var updatedAt : Date,
    var isFavorit : Boolean = false,
) : Parcelable