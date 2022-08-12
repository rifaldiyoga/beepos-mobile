package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StockResponse(
    @SerializedName("status")
    @Expose
    var status: Boolean,
    @SerializedName("data")
    @Expose
    var stockModels: List<StockModel> = mutableListOf()
) : Parcelable {

    @Parcelize
    data class StockModel (
        @SerializedName("item_id")
        @Expose
        var itemId: Int = -1,
        @SerializedName("wh_id")
        @Expose
        var whId: Int = -1,
        @SerializedName("itemid")
        @Expose
        var itemCode: String = "",
        @SerializedName("whid")
        @Expose
        var whCode: String = "",
        @SerializedName("pid")
        @Expose
        var pid: String = "",
        @SerializedName("qty")
        @Expose
        var qty: String = "",
        @SerializedName("qtyx")
        @Expose
        var qtyx: String = "",
        @SerializedName("qtypo")
        @Expose
        var qtypo: String = "",
        @SerializedName("active")
        @Expose
        var active: Boolean = false,
    ) : Parcelable
}