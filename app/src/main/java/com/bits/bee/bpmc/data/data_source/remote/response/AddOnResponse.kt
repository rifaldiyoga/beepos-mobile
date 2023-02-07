package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddOnResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,
    @SerializedName("data")
    @Expose
    var addOnModels: List<AddOnModel> = ArrayList()
) : Parcelable {

    @Parcelize
    data class AddOnModel (
        @SerializedName("id")
        @Expose
        var id: Int = 0,

        @SerializedName("code")
        @Expose
        var code: String = "",

        @SerializedName("name")
        @Expose
        var name: String = "",

        @SerializedName("note")
        @Expose
        var note: String = "",

        @SerializedName("isactive")
        @Expose
        var isActive: Boolean = true,

        @SerializedName("created_at")
        @Expose
        var createdAt: String = "",
    ) : Parcelable
}