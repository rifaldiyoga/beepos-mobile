package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 13/07/22.
 */

@Parcelize
data class SrepModel (
    @SerializedName("id")
    var id : Int?,
    @SerializedName("code")
    var code: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("city_code")
    var cityCode: String?,
    @SerializedName("address")
    var address: String?,
    @SerializedName("zipcode")
    var zipCode: String?,
    @SerializedName("phone")
    var phone: String?,
    @SerializedName("mobile")
    var mobile : String?,
    @SerializedName("email")
    var email : String?,
) : Parcelable