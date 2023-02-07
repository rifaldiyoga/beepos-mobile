package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.util.ArrayList
import kotlinx.parcelize.Parcelize

@Parcelize
data class SelectionDResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean? = null,

    @SerializedName("data")
    @Expose
    var selectionDModels: List<SelectionDModel> = ArrayList()
) : Parcelable{

    @Parcelize
    data class SelectionDModel (
        @SerializedName("selectaddon_id")
        @Expose
        var selectAddonId: Int = -1,

        @SerializedName("dno")
        @Expose
        var dno: Int = -1,

        @SerializedName("item_id")
        @Expose
        var itemId: Int = -1
    ) : Parcelable
}