package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal


/**
 * Created by aldi on 22/04/22.
 */
@Parcelize
data class ItemResponse (
    @SerializedName("status")
    var status:Boolean = false,
    @SerializedName("message")
    var msg : String = "",
    @SerializedName("data")
    var data : Data,
): Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("item")
        var item :List<ItemModel> = mutableListOf(),
//        @SerializedName("unit")
//        var unit : List<UnitModel> = mutableListOf(),
//        @SerializedName("price")
//        var price : List<PriceModel> = mutableListOf(),
    ) : Parcelable

    @Parcelize
    data class ItemModel (
        @SerializedName("id")
        @Expose
        var id: Int,

        @SerializedName("code")
        @Expose
        var code: String,

        @SerializedName("name1")
        @Expose
        var name1: String,

        @SerializedName("name2")
        @Expose
        var name2: String?,

        @SerializedName("barcode")
        @Expose
        var barcode: String,

        @SerializedName("version")
        @Expose
        var version: String,

        @SerializedName("brand_id")
        @Expose
        var brandId: Int?,

        @SerializedName("itemtype_code")
        @Expose
        var itemtypeCode: String,

        @SerializedName("usepid")
        @Expose
        var usepid: Boolean,

        @SerializedName("uniquepid")
        @Expose
        var uniquepid: Boolean,

        @SerializedName("itemgrp1_id")
        @Expose
        var itemgrp1Id: String?,

        @SerializedName("itemgrp2_id")
        @Expose
        var itemgrp2Id: Int?,

        @SerializedName("itemgrp3_id")
        @Expose
        var itemgrp3Id: Int?,

        @SerializedName("accinv")
        @Expose
        var accinv: String,

        @SerializedName("acccost")
        @Expose
        var acccost: String,

        @SerializedName("accsale")
        @Expose
        var accsale: String,

        @SerializedName("accsret")
        @Expose
        var accsret: String,

        @SerializedName("ispurc")
        @Expose
        var ispurc: Boolean,

        @SerializedName("isstock")
        @Expose
        var isstock: Boolean,

        @SerializedName("ismfg")
        @Expose
        var ismfg: Boolean,

        @SerializedName("issale")
        @Expose
        var issale: Boolean,

        @SerializedName("unitdesc")
        @Expose
        var unitdesc: String,

        @SerializedName("purcqtymin")
        @Expose
        var purcqtymin: String,

        @SerializedName("leadtime")
        @Expose
        var leadtime: String,

        @SerializedName("qtymin")
        @Expose
        var qtymin: String,

        @SerializedName("qtymax")
        @Expose
        var qtymax: String,

        @SerializedName("qtyreorder")
        @Expose
        var qtyreorder: String,

        @SerializedName("qtypo")
        @Expose
        var qtypo: String,

        @SerializedName("qtyso")
        @Expose
        var qtyso: String,

        @SerializedName("qtywip")
        @Expose
        var qtywip: String,

        @SerializedName("note")
        @Expose
        var note: String,

        @SerializedName("active")
        @Expose
        var active: Boolean,

        @SerializedName("pousepid")
        @Expose
        var pousepid: Boolean,

        @SerializedName("sousepid")
        @Expose
        var sousepid: Boolean,

        @SerializedName("vendor_id")
        @Expose
        var vendorId: Int,

        @SerializedName("vitemcode")
        @Expose
        var vitemcode: String,

        @SerializedName("purcunit")
        @Expose
        var purcunit: String,

        @SerializedName("saleunit")
        @Expose
        var saleunit: String?,

        @SerializedName("stockunit")
        @Expose
        var stockunit: String?,

        @SerializedName("created_at")
        @Expose
        var createdAt: String,

        @SerializedName("created_by")
        @Expose
        var createdBy: String,

        @SerializedName("updated_at")
        @Expose
        var updatedAt: String,

        @SerializedName("updated_by")
        @Expose
        var updatedBy: String,

        @SerializedName("costtype")
        @Expose
        var costtype: String,

        @SerializedName("isimport")
        @Expose
        var isimport: Boolean,

        @SerializedName("bucket")
        @Expose
        var bucket: String,

        @SerializedName("objkey")
        @Expose
        var objkey: String,

        @SerializedName("ispos")
        @Expose
        var ispos: Boolean,

        @SerializedName("isvariant")
        @Expose
        var isvariant: Boolean,
        @SerializedName("vcode")
        @Expose
        val vcode : String,
        @SerializedName("vcolor")
        @Expose
        val vcolor : String,
    ) : Parcelable

//    @Parcelize
//    data class ItemModel(
//        @SerializedName("id")
//        var id : Int,
//        @SerializedName("code")
//        var code : String,
//        @SerializedName("name1")
//        var name1: String,
//        @SerializedName("brand_id")
//        var brandId: Int?,
//        @SerializedName("itemtype_code")
//        var itemTypeCode : String,
//        @SerializedName("usepid")
//        var usePid : Boolean,
//        @SerializedName("uniquepid")
//        var uniqueid: Boolean,
//        @SerializedName("itemgrp1_id")
//        var itemGrp1Id : Int?,
//        @SerializedName("isstock")
//        var isStock : Boolean,
//        @SerializedName("issale")
//        var isSale : Boolean,
//        @SerializedName("unitdesc")
//        var unitdesc : String,
//        @SerializedName("note")
//        var note : String?,
//        @SerializedName("active")
//        var active : Boolean,
//        @SerializedName("saleunit")
//        var saleUnit : Int,
//        @SerializedName("stockunit")
//        var stockUnit : Int,
//    ) : Parcelable


    @Parcelize
    data class PriceModel(
        @SerializedName("item_id")
        var itemId : Int,
        @SerializedName("pricelvl_id")
        var priceLvl: ValueLabelModel,
        @SerializedName("crc_id")
        var crc: ValueLabelModel,
        @SerializedName("price1")
        var price1 : BigDecimal,
        @SerializedName("discexp1")
        var discExp1 : String,
    ) : Parcelable

}