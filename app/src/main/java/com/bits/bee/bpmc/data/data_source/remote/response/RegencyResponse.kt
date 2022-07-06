package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegencyResponse(
    @SerializedName("status")
    var status:Boolean = false,
    @SerializedName("message")
    var msg : String = "",
    @SerializedName("data")
    var data : Data
): Parcelable {

    @Parcelize
    data class Data(
        @SerializedName("data")
        var data: MutableList<RegencyModel> = mutableListOf(),
        @SerializedName("page")
        var page: Int = 0,
        @SerializedName("total_page")
        var total_page: Int = 0
    ): Parcelable

    @Parcelize
    data class RegencyModel(
        @SerializedName("code")
        val code : String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("province_code")
        val province_code: String ="",
        @SerializedName("active")
        val active : Boolean = false,
    ): Parcelable
}