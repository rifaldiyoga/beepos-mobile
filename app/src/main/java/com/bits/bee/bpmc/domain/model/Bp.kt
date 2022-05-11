package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 22/04/22.
 */
@Parcelize
data class Bp(
    var id : Int? = null,
    var code : String = "",
    var name: String = "",
    var greeting: String = "",
    var anniversary : String = "",
    var isTaxedOnSale : Boolean = false,
    var isTaxIncOnSale : Boolean = false,
    var note : String = "",
    var bpgrpId : Int? = null,
    var priceLvlId : Int = 1,
    var isActive : Boolean = true,
    var alamat : String = "",
//    var createdAt : Date,
//    var updatedAt : Date,
    var isFavorit : Boolean = false,
) : Parcelable