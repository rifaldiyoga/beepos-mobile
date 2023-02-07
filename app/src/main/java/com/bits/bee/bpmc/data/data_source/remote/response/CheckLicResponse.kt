package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CheckLicResponse(
    @SerializedName("status")
    var status: Boolean,
    @SerializedName("data")
    var data: Data?,
) : Parcelable {

    @Parcelize
    data class Data(
        @SerializedName("status")
        var status: Boolean,
        @SerializedName("data")
        var data: String?,
        @SerializedName("expdate")
        var expDate: String? ,
        @SerializedName("product")
        var product: String? ,
    ) : Parcelable

}
