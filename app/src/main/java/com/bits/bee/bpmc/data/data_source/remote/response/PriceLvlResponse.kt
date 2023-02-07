package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 26/04/22.
 */
@Parcelize
data class PriceLvlResponse (
    @SerializedName("status")
    var status:Boolean = false,
//    @SerializedName("message")
//    var msg : String = "",
    @SerializedName("data")
    var data: MutableList<PriceLvlModel> = mutableListOf()
): Parcelable {
//
//    @Parcelize
//    data class Data(
//        @SerializedName("data")
//        var data: MutableList<PriceLvlModel> = mutableListOf()
//    ) : Parcelable
    @Parcelize
    data class PriceLvlModel(
        @SerializedName("id")
        val id: Int = -1,
        @SerializedName("code")
        val code: String = "",
        @SerializedName("name")
        val name: String = "",
//        @SerializedName("active")
//        val active: Boolean = false,
        @SerializedName("updated_at")
        val updatedAt : String = "",
    ) : Parcelable
}