package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.remote.model.*
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 29/03/22.
 */
@Parcelize
data class InitialResponse (
    @SerializedName("status")
    var status:Boolean = false,
    @SerializedName("data")
    var data : Data
): Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("cmp")
        var cmp : List<CmpModel> = mutableListOf(),
        @SerializedName("reg")
        var reg : List<RegModel> = mutableListOf(),
        @SerializedName("usr")
        var usr : List<UsrModel> = mutableListOf(),
        @SerializedName("usrgrp")
        var usrGrp : List<UsrGrpModel> = mutableListOf(),
        @SerializedName("grpprv")
        var grpPrv : List<GrpPrvModel> = mutableListOf(),
        @SerializedName("crc")
        var crc : List<CrcModel> = mutableListOf(),
        @SerializedName("wh")
        var wh : List<WhModel> = mutableListOf(),
    ) : Parcelable


    @Parcelize
    data class ValueLabelStringModel(
        @SerializedName("value")
        var value : String = "",
        @SerializedName("label")
        var label : String = "",
    ) : Parcelable

}