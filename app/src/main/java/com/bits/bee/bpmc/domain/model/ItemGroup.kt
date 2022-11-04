package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemGroup (
    var id : Int? = null,
    var code : String,
    var name: String,
    var level : Int,
    var upId : Int,
    var isPos : Boolean,
) : Parcelable