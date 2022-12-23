package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemImageResponse (
    @SerializedName("status")
    var status:Boolean = false,
    @SerializedName("data")
    var data : MutableList<Data> = mutableListOf(),
) : Parcelable {

    @Parcelize
    data class Data(
        @SerializedName("id")
        var id : Int,
        @SerializedName("refid")
        var refId : Int,
        @SerializedName("bucket")
        var bucket : String,
        @SerializedName("objkey")
        var objkey : String,
    ) : Parcelable

}