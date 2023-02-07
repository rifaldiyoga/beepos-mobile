package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetachResponse(
    @SerializedName("status")
    @Expose
    private var status: Boolean,
    @SerializedName("data")
    @Expose
    var data: Data
): Parcelable {

    @Parcelize
    data class Data(
        @SerializedName("status")
        @Expose
        var status: Boolean,
        @SerializedName("data")
        @Expose
        var data: String
    ): Parcelable
}