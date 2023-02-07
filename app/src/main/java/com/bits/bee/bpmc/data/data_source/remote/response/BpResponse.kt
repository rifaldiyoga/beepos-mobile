package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.local.model.BpAddrEntity
import com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class BpResponse (
    @SerializedName("status")
    var status:Boolean = false,
    @SerializedName("message")
    var msg : String = "",
    @SerializedName("data")
    var data : List<BpModel> = mutableListOf()
):Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var data :BpModel
    ) : Parcelable

    @Parcelize
    data class BpModel(
        @SerializedName("id")
        @Expose
        var id: Int = -1,
        @SerializedName("code")
        @Expose
        var code : String ,
        @SerializedName("name")
        @Expose
        var name : String ,
        @SerializedName("mobile")
        @Expose
        var phone : String?,
        @SerializedName("bp_id")
        @Expose
        var  bpId:String,
        @SerializedName("address")
        @Expose
        var address:String? ,
        @SerializedName("taxedonsale")
        @Expose
        var saleistaxed:Boolean,
        @SerializedName("taxinconsale")
        @Expose
        var saletaxinc:Boolean,
        @SerializedName("pricelvl_id")
        @Expose
        var pricelvl_id:Int,
        @SerializedName("city_code")
        @Expose
        var city_code:String? ,
        @SerializedName("email")
        @Expose
        var email:String ,
        @SerializedName("bpgrp1_id")
        @Expose
        var bpgrpid: Int?,
        @SerializedName("created_at")
        @Expose
        var created_at:String? ,
        @SerializedName("created_by")
        @Expose
        var createdBy:String? ,
    ) : Parcelable {

    }

    @Parcelize
    data class BpAddrModel(
        @SerializedName("id")
        var id : Int = -1,
        @SerializedName("bp_id")
        var bpId : Int = -1,
        @SerializedName("name")
        var name: String = "",
        @SerializedName("greeting")
        var greeting: String = "",
        @SerializedName("address")
        var address : String = "",
        @SerializedName("phone")
        var phone : String = "",
        @SerializedName("zipcode")
        var zipCode : String = "",
        @SerializedName("email")
        var email : List<EmailModel> = mutableListOf(),
        @SerializedName("note")
        var note : String = "",
        @SerializedName("isbilladdr")
        var isBillAddr : Boolean = false,
        @SerializedName("isshipaddr")
        var isShipAddr : Boolean = false,
        @SerializedName("ismainaddr")
        var isMainAddr : Boolean = false,
        @SerializedName("province_code")
        var provinceCode : ValueLabelModel,
        @SerializedName("regency_code")
        var regencyCode : ValueLabelModel,
        @SerializedName("district_code")
        var districtId : ValueLabelModel,
        @SerializedName("created_at")
        var createdAt : Date,
        @SerializedName("updated_at")
        var updatedAt : Date,
    ) : Parcelable {


    }

    @Parcelize
    data class EmailModel(
        @SerializedName("id")
        var id : Int = -1,
        @SerializedName("refid")
        var refId : Int = -1,
        @SerializedName("reftype")
        var refType : String = "",
        @SerializedName("email")
        var email : String = "",
    ) : Parcelable
}