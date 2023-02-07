package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EdcSurcResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,
    @SerializedName("data")
    @Expose
    var data: List<DataEdcSurc> = ArrayList()
) :Parcelable{

    @Parcelize
    data class DataEdcSurc (
        @SerializedName("id")
        @Expose
        var id: Int = 0,
        @SerializedName("edcsurcno")
        @Expose
        var edcSurcNo: String = "",
        @SerializedName("edc_id")
        @Expose
        var edcId: Int = -1,
        @SerializedName("cctype")
        @Expose
        var ccType: String = "",
        @SerializedName("cctypedesc")
        @Expose
        var ccTypeDesc: String = "",
        @SerializedName("surcexp")
        @Expose
        var surcExp: String = "",
        @SerializedName("mdrexp")
        @Expose
        var mdrExp: String = "",
        @SerializedName("surcacc_id")
        @Expose
        var surcAccId: Int = -1,
        @SerializedName("mdracc_id")
        @Expose
        var mdrAccId: Int = -1,
        @SerializedName("edcsurctype")
        @Expose
        var edcSurcType: String = "",
        @SerializedName("active")
        @Expose
        var active: Boolean = false,
    ) : Parcelable
}