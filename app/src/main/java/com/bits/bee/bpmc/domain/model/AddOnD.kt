package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class AddOnD (
    var id : Int?,
    var addOnId: Int,
    var selectionId: Int,
    var idx : Int,
    var upIdx : Int,
    var isSkip : Boolean,
) : Parcelable