package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class ItemAddOn (
    var id : Int,
    var addOnId: Int,
    var code: String,
    var itemId : Int,
) : Parcelable