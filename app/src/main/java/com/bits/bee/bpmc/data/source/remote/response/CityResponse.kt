package com.bits.bee.bpmc.data.source.remote.response

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.source.local.model.*
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
    var data : Data
): Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var data : MutableList<CityModel> = mutableListOf()
    ) : Parcelable

    @Parcelize
    data class CityModel(
        @SerializedName("code")
        val code: String = "",
        @SerializedName("name")
        val name : String = "",
        @SerializedName("active")
        val isActive : Boolean = false,
    ) : Parcelable {

        fun toCity() : City{
            return City(code, name, isActive)
        }

    }

}