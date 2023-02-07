package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 13/07/22.
 */

@Parcelize
data class WhModel (
    @SerializedName("id")
    var id : Int,
    @SerializedName("code")
    var code : String,
    @SerializedName("name")
    var name: String,
    @SerializedName("active")
    var active: Boolean,
) : Parcelable