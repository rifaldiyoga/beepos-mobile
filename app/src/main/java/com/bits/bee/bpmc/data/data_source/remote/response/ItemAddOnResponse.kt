package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.util.ArrayList
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemAddOnResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,

    @SerializedName("data")
    @Expose
    var data: List<Datum> = ArrayList()
) : Parcelable {

    @Parcelize
    data class Datum (
        @SerializedName("id")
        @Expose
        var id: Int = -1,

        @SerializedName("item_id")
        @Expose
        var item_id: Int = -1,

        @SerializedName("addon_id")
        @Expose
        var addon_id: Int = -1,
    ) : Parcelable
}