package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class UsrGrp (
    var id : Int?,
    var usrCode : String,
    var disabled : Boolean,
    var grpId : Int,
    var usrId : String,
    var updatedAt : Date
) : Parcelable