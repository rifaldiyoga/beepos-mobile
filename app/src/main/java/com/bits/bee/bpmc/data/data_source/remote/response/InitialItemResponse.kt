package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize
import java.util.ArrayList

/**
 * Created by bits on 09/09/16.
 */
@Parcelize
data class InitialItemResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,

    @SerializedName("data")
    @Expose
    var item: Item? = null,
) : Parcelable {

    @Parcelize
    data class Item (
        @SerializedName("item")
        @Expose
        var data: List<Datum>? = null
    ) : Parcelable

    @Parcelize
    data class Datum (
        @SerializedName("id")
        @Expose
        var id: Int? = null,

        @SerializedName("code")
        @Expose
        var code: String="",

        @SerializedName("name1")
        @Expose
        var name1: String="",

        @SerializedName("name2")
        @Expose
        var name2: String="",

        @SerializedName("barcode")
        @Expose
        var barcode: String="",

        @SerializedName("version")
        @Expose
        var version: String="",

        @SerializedName("brand_id")
        @Expose
        var brandId: Int? = null,

        @SerializedName("itemtype_code")
        @Expose
        var itemtypeCode: String="",

        @SerializedName("usepid")
        @Expose
        var usepid: Boolean = false,

        @SerializedName("uniquepid")
        @Expose
        var uniquepid: Boolean = false,

        @SerializedName("itemgrp1_id")
        @Expose
        var itemgrp1Id: String="",

        @SerializedName("itemgrp2_id")
        @Expose
        var itemgrp2Id: Int? = null,

        @SerializedName("itemgrp3_id")
        @Expose
        var itemgrp3Id: Int? = null,

        @SerializedName("accinv")
        @Expose
        var accinv: String="",

        @SerializedName("acccost")
        @Expose
        var acccost: String="",

        @SerializedName("accsale")
        @Expose
        var accsale: String="",

        @SerializedName("accsret")
        @Expose
        var accsret: String="",

        @SerializedName("ispurc")
        @Expose
        var ispurc: Boolean = false,

        @SerializedName("isstock")
        @Expose
        var isstock: Boolean = false,

        @SerializedName("ismfg")
        @Expose
        var ismfg: Boolean = false,

        @SerializedName("issale")
        @Expose
        var issale: Boolean = false,

        @SerializedName("unitdesc")
        @Expose
        var unitdesc: String="",

        @SerializedName("purcqtymin")
        @Expose
        var purcqtymin: String="",

        @SerializedName("leadtime")
        @Expose
        var leadtime: String="",

        @SerializedName("qtymin")
        @Expose
        var qtymin: String="",

        @SerializedName("qtymax")
        @Expose
        var qtymax: String="",

        @SerializedName("qtyreorder")
        @Expose
        var qtyreorder: String="",

        @SerializedName("qtypo")
        @Expose
        var qtypo: String="",

        @SerializedName("qtyso")
        @Expose
        var qtyso: String="",

        @SerializedName("qtywip")
        @Expose
        var qtywip: String="",

        @SerializedName("note")
        @Expose
        var note: String="",

        @SerializedName("active")
        @Expose
        var active: Boolean = false,

        @SerializedName("pousepid")
        @Expose
        var pousepid: Boolean = false,

        @SerializedName("sousepid")
        @Expose
        var sousepid: Boolean = false,

        @SerializedName("vendor_id")
        @Expose
        var vendorId: Int? = null,

        @SerializedName("vitemcode")
        @Expose
        var vitemcode: String="",

        @SerializedName("purcunit")
        @Expose
        var purcunit: String="",

        @SerializedName("saleunit")
        @Expose
        var saleunit: String="",

        @SerializedName("stockunit")
        @Expose
        var stockunit: String="",

        @SerializedName("created_at")
        @Expose
        var createdAt: String="",

        @SerializedName("created_by")
        @Expose
        var createdBy: String="",

        @SerializedName("updated_at")
        @Expose
        var updatedAt: String="",

        @SerializedName("updated_by")
        @Expose
        var updatedBy: String="",

        @SerializedName("costtype")
        @Expose
        var costtype: String="",

        @SerializedName("isimport")
        @Expose
        var isimport: Boolean = false,

        @SerializedName("bucket")
        @Expose
        var bucket: String="",

        @SerializedName("objkey")
        @Expose
        var objkey: String="",

        @SerializedName("ispos")
        @Expose
        var ispos: Boolean = false,

        @SerializedName("vcode")
        @Expose
        var vcode: String="",

        @SerializedName("vcolor")
        @Expose
        var vcolor: String="",

        @SerializedName("isvariant")
        @Expose
        var isvariant: Boolean = false,
    ): Parcelable

}