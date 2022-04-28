package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 20/04/22.
 */
@Parcelize
data class Channel (
    var id : Int,
    var code : String,
    var name: String,
    var active: Boolean,
    var isPos : Boolean,
    var createdBy : Int,
    var createdAt : Long,
    var updatedBy : Int,
    var updatedAt : Long,
    var color : String,
    var priceLvlId : Int?,
) : Parcelable