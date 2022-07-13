package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 13/07/22.
 */
@Parcelize
data class CmpModel(
    @SerializedName("id")
    var id : Int?,
    @SerializedName("city_code")
    var cityCode : String,
    @SerializedName("crc_id")
    var crcId : Int,
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
    var fiscalYear : String,
    @SerializedName("ownername")
    var ownerName : String?,
    @SerializedName("ownertaxregno")
    var ownerTaxRegNo : String?,
    @SerializedName("formserno")
    var formSerno : String,
    @SerializedName("taxregno")
    var taxRegNo : String,
    @SerializedName("vatregno")
    var vatRegNo : String,
    @SerializedName("costtype")
    var cossType : String,
) : Parcelable