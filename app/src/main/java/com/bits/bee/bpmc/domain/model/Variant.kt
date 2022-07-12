package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class Variant (
    var id : Int,
    var code : String,
    var name: String,
    var itgrpId: Int,
    var picPath : String,
    var isFavorit : Boolean,
    var isAvailable : Boolean,
) : Parcelable