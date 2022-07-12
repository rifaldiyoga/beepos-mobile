package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by dwiki bits on 7/15/2018.
 */
@Parcelize
data class EdcResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,

    @SerializedName("data")
    @Expose
    var data: List<DataEdc> = ArrayList()
) : Parcelable{

    @Parcelize
    data class DataEdc (
        @SerializedName("id")
        @Expose
        var id: Int = 0,
        @SerializedName("code")
        @Expose
        var code: String = "",
        @SerializedName("cash_id")
        @Expose
        var cashId: String = "",
        @SerializedName("name")
        @Expose
        var name: String = "",
        @SerializedName("note")
        @Expose
        var note: String = "",
        @SerializedName("surcpayto")
        @Expose
        var surcpayto: String = "",
        @SerializedName("branch_id")
        @Expose
        var branchId: String = "",
        @SerializedName("active")
        @Expose
        var active: Boolean = false,
    ) : Parcelable

}