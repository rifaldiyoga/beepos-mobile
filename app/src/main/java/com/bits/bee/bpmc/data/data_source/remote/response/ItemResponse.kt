package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.local.model.ItemEntitiy
import com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel
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
        var item : ItemModel,
        @SerializedName("unit")
        var unit : UnitModel,
        @SerializedName("price")
        var price : PriceModel,
    ) : Parcelable

    @Parcelize
    data class ItemModel(
        @SerializedName("id")
        var id : Int,
        @SerializedName("code")
        var code : String,
        @SerializedName("name1")
        var name1: String,
        @SerializedName("brand_id")
        var brandId: Int,
        @SerializedName("itemtype_code")
        var itemTypeCode : String,
        @SerializedName("usepid")
        var usePid : Boolean,
        @SerializedName("uniquepid")
        var uniqueid: Boolean,
        @SerializedName("itemgrp1_id")
        var itemGrp1Id : Int,
        @SerializedName("isstock")
        var isStock : Boolean,
        @SerializedName("issale")
        var isSale : Boolean,
        @SerializedName("unitdesc")
        var unitdesc : String,
        @SerializedName("note")
        var note : String,
        @SerializedName("active")
        var active : Boolean,
        @SerializedName("saleunit")
        var saleUnit : Int,
        @SerializedName("stockunit")
        var stockUnit : Int,
    ) : Parcelable

    @Parcelize
    data class UnitModel(
        @SerializedName("id")
        var id : Int,
        @SerializedName("item_id")
        var itemId : Int,
        @SerializedName("idx")
        var idx: Int,
        @SerializedName("unit")
        var unit: String,
        @SerializedName("conv")
        var conv : Int,
    ) : Parcelable

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
        var discExp1 : BigDecimal,
    ) : Parcelable

}