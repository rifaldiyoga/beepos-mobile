package com.bits.bee.bpmc.data.source.remote.post

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegisterPost(
    @SerializedName("status")
    var status: Boolean?,
    @SerializedName("username")
    var username: String="",
    @SerializedName("email")
    var email: String="",
    @SerializedName("address")
    var address: String="",
    @SerializedName("city_id")
    var city_id: String="",
    @SerializedName("bussiness")
    var bussiness: String="",
    @SerializedName("bussiness2")
    var bussiness2: String="",
    @SerializedName("company")
    var company: String="",
    @SerializedName("mobile")
    var mobile: String="",
    @SerializedName("regid")
    var regid: String="",
    @SerializedName("step")
    var step:Int = 0,
    @SerializedName("cust_id")
    var cust_id:Int = 0,
    @SerializedName("otp_tipe")
    var otptipe: String? = "",
    @SerializedName("dataUTM")
    var data_utm: UTM

    ): Parcelable{
        @Parcelize
        data class UTM(
            @SerializedName("utm_source")
            private var utm_source: String="",
            @SerializedName("utm_medium")
            private val utm_medium: String="",
            @SerializedName("utm_campaign")
            private val utm_campaign: String="",
            @SerializedName("utm_term")
            private val utm_term: String="",
            @SerializedName("utm_content")
            private val utm_content: String = ""
        ) : Parcelable
}