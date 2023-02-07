package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DbResponse (
    @SerializedName("status")
    @Expose
    var status: String,
    @SerializedName("message")
    @Expose
    var dataDb: List<DataDb> = ArrayList(),
) : Parcelable{

    @Parcelize
    data class DataDb(
        @SerializedName("auth_key")
        @Expose
        var auth_key: String
    ) : Parcelable
}