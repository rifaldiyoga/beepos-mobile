package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LicResponse(
    @SerializedName("status")
    var status: Boolean = false,
    @SerializedName("data")
    var data: Data? = null
): Parcelable {

    @Parcelize
    data class Data(
        @SerializedName("status")
        var status: Boolean = false,
        @SerializedName("data")
        var data: String = "",
        @SerializedName("serial_number")
        var serialNumber: String = "",
        @SerializedName("expdate")
        var expdate: String = "",
        @SerializedName("item")
        var item: String = "",
        @SerializedName("cmpname")
        var cmpname: String = ""
    ):Parcelable
}