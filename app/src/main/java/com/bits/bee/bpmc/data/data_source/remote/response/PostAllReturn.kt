package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostAllReturn(
    @SerializedName("status")
    var status: Boolean = false,
    @SerializedName("data")
    var data: String? = null
): Parcelable