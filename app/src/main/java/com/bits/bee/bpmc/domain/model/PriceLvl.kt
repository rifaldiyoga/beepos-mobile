package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Created by aldi on 26/04/22.
 */
@Parcelize
data class PriceLvl(
    var id : Int,
    var name: String,
    var code : String,
//    var active : Boolean,
    var updatedAt : Date,
) : Parcelable