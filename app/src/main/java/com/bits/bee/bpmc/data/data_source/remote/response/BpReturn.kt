package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BpReturn(
    @SerializedName("status")
    var status: Boolean? = false,
    @SerializedName("data")
    var data: MutableList<BpCodeReturn>? = null
): Parcelable{

    @Parcelize
    data class BpCodeReturn(
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("code")
        var code: String? = null
    ): Parcelable
}