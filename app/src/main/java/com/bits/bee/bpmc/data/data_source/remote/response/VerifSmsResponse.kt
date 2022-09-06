package com.bits.bee.bpmc.data.data_source.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class VerifSmsResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean,
    @SerializedName("datas")
    @Expose
    var responses: String,
    @SerializedName("data")
    @Expose
    var userData: UserData,
) {

    data class UserData (
        @SerializedName("db_serial_number")
        @Expose
        var serialNumber: String = "",
        @SerializedName("myauthkey")
        @Expose
        var myauthkey: String? = null
    )

    @SerializedName("db")
    @Expose
    var dataDb: List<DataDb> = ArrayList()

    class DataDb (
        @SerializedName("id")
        @Expose
        var id_username: Int,
        @SerializedName("cmpname")
        @Expose
        var cmpname: String,
        @SerializedName("dbname")
        @Expose
        var dbname: String,
        @SerializedName("dbhost")
        @Expose
        var dbhost: String,

        @SerializedName("jasperhost")
        @Expose
        var jasperhost: String,

        @SerializedName("serial_number")
        @Expose
        var serialNumber: String,

        @SerializedName("trial")
        @Expose
        var trial: String,
    )

}