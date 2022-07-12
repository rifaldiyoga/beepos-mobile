package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.local.model.CityEntity
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 29/03/22.
 */
@Parcelize
data class CityResponse (
    @SerializedName("status")
    var status:Boolean = false,
    @SerializedName("message")
    var msg : String = "",
    @SerializedName("data")
    var data : MutableList<CityModel> = mutableListOf()
): Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var data : MutableList<CityModel> = mutableListOf()
    ) : Parcelable

    @Parcelize
    data class CityModel (
        @SerializedName("id")
        val id: Int = -1,
        @SerializedName("code")
        val code: String = "",
        @SerializedName("name")
        val name : String = "",
//        @SerializedName("active")
//        val isActive : Boolean = false,
    ) : Parcelable

}