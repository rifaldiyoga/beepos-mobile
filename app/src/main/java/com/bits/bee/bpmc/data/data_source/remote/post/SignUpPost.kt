package com.bits.bee.bpmc.data.data_source.remote.post

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.remote.model.UTM
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SignUpPost(
    @SerializedName("status")
    var status: Boolean? = null,
    @SerializedName("username")
    var username: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("address")
    var address: String? = "",
    @SerializedName("city_id")
    var city_id: String? = null,
    @SerializedName("bussiness")
    var bussiness: String? = "",
    @SerializedName("bussiness2")
    var bussiness2: String? = null,
    @SerializedName("company")
    var company: String? = "",
    @SerializedName("mobile")
    var mobile: String? = null,
    @SerializedName("regid")
    var regid: Int? = null,
    @SerializedName("step")
    var step:Int = 1,
    @SerializedName("cust_id")
    var cust_id:Int? = null,
    @SerializedName("otp_tipe")
    var otptipe: String? = null,
    @SerializedName("dataUTM")
    var data_utm: UTM? = null
): Parcelable