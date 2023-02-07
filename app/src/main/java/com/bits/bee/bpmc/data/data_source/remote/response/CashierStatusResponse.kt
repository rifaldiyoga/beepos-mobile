package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 07/09/22
 */

@Parcelize
data class CashierStatusResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean,

    @SerializedName("data")
    @Expose
    var data: Data,
) : Parcelable{

    @Parcelize
    data class Data (
        @SerializedName("status")
        @Expose
        var status_cashier: Boolean,

        @SerializedName("data")
        @Expose
        var data_cashier: String,
    ) : Parcelable


}