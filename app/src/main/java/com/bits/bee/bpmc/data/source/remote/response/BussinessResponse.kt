package com.bits.bee.bpmc.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BusinessResponse(
    @SerializedName("status")
    var status: Boolean = false,
    @SerializedName("data")
    var data: List<Data>?
): Parcelable{

    @Parcelize
    data class Data(
        @SerializedName("kategori")
        var kategori: String="",
        @SerializedName("usaha")
        var dataUsaha: List<DataUsaha>?
    ): Parcelable

    @Parcelize
    data class DataUsaha(
        @SerializedName("id")
        var id: Int = -1,
        @SerializedName("name")
        var name: String="",
        @SerializedName("kategori_usaha_id")
        var kategori: String="",
        @SerializedName("created_at")
        var created_at: String=""
    ): Parcelable
}