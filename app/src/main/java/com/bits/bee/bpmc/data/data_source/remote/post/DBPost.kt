package com.bits.bee.bpmc.data.data_source.remote.post

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DBPost(
    @SerializedName("username")
    var username: String = "",
    @SerializedName("dbname")
    var dbname: String = ""
): Parcelable {
}