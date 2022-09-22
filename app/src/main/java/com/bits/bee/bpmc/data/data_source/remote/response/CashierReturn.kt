package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CashierReturn(
    @SerializedName("status")
    var status: Boolean = false,
    @SerializedName("data")
    var data: Data? = null
): Parcelable {

    @Parcelize
    data class Data(
        @SerializedName("status")
        var status_cashier: Boolean = false,
        @SerializedName("data")
        var data_cashier: String = ""
    ): Parcelable

}