package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegisterResponse (
    @SerializedName("status")
    var status: Boolean=false,
    @SerializedName("error")
    var userData: String="",
    @SerializedName("data")
    var responses: String="",
    @SerializedName("db")
    var dataDb: List<DataDb>?
    ): Parcelable{

    @Parcelize
    data class UserData(
        @SerializedName("username")
        var username: String?,
        @SerializedName("email")
        var email: String?,
        @SerializedName("address")
        var address: String?,
        @SerializedName("city_id")
        var city_id: String?,
        @SerializedName("bussiness")
        var bussiness: String,
        @SerializedName("company")
        var company: String?,
        @SerializedName("mobile")
        var mobile: Int?
    ): Parcelable

    @Parcelize
    data class DataDb(
        @SerializedName("id")
        var id_username: Int= -1,
        @SerializedName("cmpname")
        var cmpname: String="",
        @SerializedName("dbname")
        var dbname: String="",
        @SerializedName("dbhost")
        var dbhost: String="",
        @SerializedName("jasperhost")
        private val jasperhost: String="",
        @SerializedName("serial_number")
        private val serial_number: String?,
        @SerializedName("trial")
        @Expose
        private val trial: String?
    ):Parcelable
    }
