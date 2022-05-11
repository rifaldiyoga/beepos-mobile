package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 02/03/22.
 */

@Parcelize
data class LoginResponse (
    @SerializedName("status")
    var status : String = "",
    @SerializedName("msg")
    var msg : Msg?,
    @SerializedName("db")
    var db : List<Db>?
) : Parcelable {

    @Parcelize
    data class Msg(
        @SerializedName("username")
        var username : String = "",
        @SerializedName("password")
        var password : String = ""
    ) : Parcelable

    @Parcelize
    data class Db(
        @SerializedName("id")
        var id : Int = -1,
        @SerializedName("cmpname")
        var cmpName : String = "",
        @SerializedName("dbname")
        var dbName : String = "",
        @SerializedName("dbhost")
        var dbhost : String = "",
        @SerializedName("jasperhost")
        var jasperHost : String = "",
        @SerializedName("serial_number")
        var serialNumber : String = "",
        @SerializedName("trial")
        var trial : String = "",
        ) : Parcelable

}