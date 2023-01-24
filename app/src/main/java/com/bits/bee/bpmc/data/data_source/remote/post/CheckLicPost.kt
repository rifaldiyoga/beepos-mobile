package com.bits.bee.bpmc.data.data_source.remote.post

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CheckLicPost(
    @SerializedName("license")
    var license: String = "",
    @SerializedName("deviceinfo")
    var deviceinfo: String = "",
) : Parcelable
