package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

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
    var createdAt : Date = Date(),
    var createdBy : Int = -1,
    var updatedAt : Date? = Date(),
    var updatedBy : Int? = -1,
    var isFavorit : Boolean = false,
    var bpAddr: BpAddr? = null,
    var bpAccList : List<BpAcc> = mutableListOf()
) : Parcelable