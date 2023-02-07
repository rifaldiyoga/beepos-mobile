package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 30/06/22.
 */
@Parcelize
data class CcType (
    var id : Int?,
    var cctype: String,
    var cctypeDesc : String,
) : Parcelable