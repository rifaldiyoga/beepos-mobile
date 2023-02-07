package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize
import java.util.ArrayList

@Parcelize
data class AddOnDResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean,
    @SerializedName("data")
    @Expose
    var data: List<AddOnDModel> = ArrayList()
) : Parcelable {

    @Parcelize
    data class AddOnDModel (
        @SerializedName("addon_id")
        @Expose
        var addOnId: Int = -1,
        @SerializedName("idx")
        @Expose
        var idx: Int = -1,
        @SerializedName("selectaddon_id")
        @Expose
        var selectaddonId: Int = -1,
        @SerializedName("isskip")
        @Expose
        var isSkip: Boolean = false,
    ) : Parcelable
}