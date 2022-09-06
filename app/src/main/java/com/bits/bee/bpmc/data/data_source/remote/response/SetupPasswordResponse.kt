package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/**
 * Created by aldi on 30/08/22.
 */
@Parcelize
data class SetupPasswordResponse (
    @SerializedName("status")
    @Expose var status: Boolean,

    //    @SerializedName("error")
    //    @Expose
    //    String userData;
    @SerializedName("error")
    @Expose
    var errorData: List<ErrorData> = mutableListOf(),
    @SerializedName("data")
    @Expose
    var responses: String = "",
    @SerializedName("msg")
    @Expose
    var userData : ErrorData
) : Parcelable {

    @Parcelize
    data class ErrorData (
        @SerializedName("username")
        @Expose
        var username: String = "",

        @SerializedName("email")
        @Expose
        var email: String = "",

        @SerializedName("address")
        @Expose
        var address: String = "",

        @SerializedName("city_id")
        @Expose
        var city_id: String = "",

        @SerializedName("bussiness")
        @Expose
        var bussiness: String = "",
        @SerializedName("company")
        @Expose
        var company: String = "",

        @SerializedName("mobile")
        @Expose
        var mobile: String = "",
    ) : Parcelable

    @SerializedName("db")
    @Expose
    var dataDb: List<DataDb>? = null

    @Parcelize
    class DataDb (
        @SerializedName("id")
        @Expose
        var id_username: Int? = null,

        @SerializedName("cmpname")
        @Expose
        var cmpname: String? = null,

        @SerializedName("dbname")
        @Expose
        var dbname: String? = null,

        @SerializedName("dbhost")
        @Expose
        var dbhost: String? = null,

        @SerializedName("jasperhost")
        @Expose
        var jasperhost: String? = null,

        @SerializedName("serial_number")
        @Expose
        var serialNumber: String? = null,

        @SerializedName("trial")
        @Expose
        var trial: String? = null,
    ) : Parcelable

}