package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DistrictResponse(
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
        var data: MutableList<DistrictModel> = mutableListOf(),
        @SerializedName("page")
        var page: Int = 0,
        @SerializedName("total_page")
        var total_page: Int = 0
    ): Parcelable

    @Parcelize
    data class DistrictModel(
        @SerializedName("code")
        val code : String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("regency_code")
        val regency_code: String ="",
        @SerializedName("active")
        val active : Boolean = false,
    ): Parcelable
}