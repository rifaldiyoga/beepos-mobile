package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GopayStatusResponse(
    @SerializedName("status")
    @Expose
    private var status: Boolean,
    @SerializedName("data")
    @Expose
    var data: Data
): Parcelable {

    @Parcelize
    data class Data(
        @SerializedName("order_id")
        @Expose
        var order_id: String,
        @SerializedName("transaction_id")
        @Expose
        var transaction_id: String,
        @SerializedName("transaction_status")
        @Expose
        var transaction_status: String
    ): Parcelable
}