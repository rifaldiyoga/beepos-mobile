package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.remote.model.UsrModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BranchUserResponse(
    @SerializedName("status")
    var status: Boolean = false,
    @SerializedName("data")
    var data: MutableList<DataBranchUser> = mutableListOf()
): Parcelable {

    @Parcelize
    data class DataBranchUser(
        @SerializedName("usr_id")
        var usrId: Int = -1,
        @SerializedName("login")
        var login: String,
        @SerializedName("name")
        var name: String,
        @SerializedName("pin")
        var pin: String,
        @SerializedName("active")
        var status: Boolean = false
    ): Parcelable
}