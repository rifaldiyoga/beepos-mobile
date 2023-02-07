package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/**
 * Created by aldi on 14/07/22.
 */
@Parcelize
data class ItemKitchenResponse (
    @SerializedName("status")
    @Expose
     var status: Boolean,

    @SerializedName("data")
    @Expose
     var data: List<ItemKitchenData> = ArrayList()
) : Parcelable{

    @Parcelize
    data class ItemKitchenData (
        @SerializedName("id")
        @Expose
        var id: Int,
        @SerializedName("item_id")
        @Expose
        var item_id: Int,
        @SerializedName("kitchen_id")
        @Expose
        var kitchen_id: Int,
        @SerializedName("created_at")
        @Expose
        var created_at: String,
        @SerializedName("created_by")
        @Expose
        var created_by: Int,

        @SerializedName("updated_at")
        @Expose
        var updated_at: String,

        @SerializedName("updated_by")
        @Expose
        var updated_by: Int,
    ) : Parcelable
}