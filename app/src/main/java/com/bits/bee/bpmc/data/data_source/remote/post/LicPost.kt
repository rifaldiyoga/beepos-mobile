package com.bits.bee.bpmc.data.data_source.remote.post

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LicPost(
    @SerializedName("email")
    var email: String = "",
    @SerializedName("deviceinfo")
    var deviceinfo: String = "",
    @SerializedName("devicetype")
    var type: String? = "",
    @SerializedName("reactivate")
    var reactive: Boolean = false,
    @SerializedName("deviceversion")
    var version: String = "",
    @SerializedName("selectedlicense")
    var selectedlicense: String = ""
): Parcelable {
}