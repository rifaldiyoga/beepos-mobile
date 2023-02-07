package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/**
 * Created by aldi on 06/09/22
 */
@Parcelize
data class LicenseResponse (
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
        var status: Boolean,
        @SerializedName("data")
        @Expose
        var data: String,
        @SerializedName("serial_number")
        @Expose
        var serialNumber: String,
        @SerializedName("expdate")
        @Expose
        var expdate: String,
        @SerializedName("item")
        @Expose
        var item: String,
        @SerializedName("cmpname")
        @Expose
        var cmpname: String,
    ) : Parcelable

}