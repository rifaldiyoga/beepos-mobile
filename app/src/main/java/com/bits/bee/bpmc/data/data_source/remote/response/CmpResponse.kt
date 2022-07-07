package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 29/03/22.
 */
@Parcelize
data class CmpResponse (
    @SerializedName("status")
    var status:Boolean = false,
    @SerializedName("message")
    var msg : String = "",
    @SerializedName("data")
    var data : CmpModel
): Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var data : MutableList<CmpModel> = mutableListOf()
    ) : Parcelable


    @Parcelize
    data class CmpModel(
        @SerializedName("id")
        var id : Int?,
        @SerializedName("regency_code")
        var cityCode : ValueLabelStringModel,
        @SerializedName("crc_id")
        var crcId : ValueLabelModel,
        @SerializedName("name")
        var name : String,
        @SerializedName("address")
        var address : String,
        @SerializedName("phone")
        var phone : String,
        @SerializedName("fax")
        var fax : String,
        @SerializedName("zipcode")
        var zipCode : String,
        @SerializedName("startdate")
        var startDate : String,
        @SerializedName("fiscalyear")
        var fiscalYear : Int,
        @SerializedName("ownername")
        var ownerName : String,
        @SerializedName("ownertaxregno")
        var ownerTaxRegNo : String,
        @SerializedName("formserno")
        var formSerno : String,
        @SerializedName("taxregno")
        var taxRegNo : String,
        @SerializedName("vatregno")
        var vatRegNo : String,
        @SerializedName("costtype")
        var cossType : String,
    ) : Parcelable

    @Parcelize
    data class ValueLabelStringModel(
        @SerializedName("value")
        var value : String = "",
        @SerializedName("label")
        var label : String = "",
    ) : Parcelable

}