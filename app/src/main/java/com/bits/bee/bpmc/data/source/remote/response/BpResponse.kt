package com.bits.bee.bpmc.data.source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.source.local.model.Bp
import com.bits.bee.bpmc.data.source.local.model.BpAddr
import com.bits.bee.bpmc.data.source.remote.model.ValueLabelModel
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
    var data : Data
):Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var data : MutableList<BpModel> = mutableListOf()
    ) : Parcelable

    @Parcelize
    data class BpModel(
        @SerializedName("id")
        var id : Int = -1,
        @SerializedName("code")
        var code : String = "",
        @SerializedName("name")
        var name: String = "",
        @SerializedName("greeting")
        var greeting: String = "",
        @SerializedName("anniversary")
        var anniversary : String = "",
        @SerializedName("taxedonsale")
        var isTaxedOnSale : Boolean = false,
        @SerializedName("taxinconsale")
        var isTaxIncOnSale : Boolean = false,
        @SerializedName("note")
        var note : String = "",
        @SerializedName("bpgrp1_id")
        var bpgrpId : Int = -1,
        @SerializedName("pricelvl_id")
        var priceLvlId : Int = -1,
        @SerializedName("active")
        var isActive : Boolean = false,
        @SerializedName("bpaddr")
        var bpAddr : List<BpAddrModel> = mutableListOf()

    ) : Parcelable {

        fun toBp() : Bp {
            return Bp(id, code, name, greeting, anniversary, isTaxedOnSale, isTaxIncOnSale, note, bpgrpId, priceLvlId, isActive)
        }

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

        fun toBpAddr() : BpAddr {
            return BpAddr(id, bpId, name, greeting, address, phone, zipCode, if(email.isNotEmpty()) email[0].email else "", note, isBillAddr, isShipAddr, isMainAddr, provinceCode.value, regencyCode.value, districtId.value, createdAt, updatedAt)
        }

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