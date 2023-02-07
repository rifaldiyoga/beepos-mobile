package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal


/**
 * Created by aldi on 14/07/22.
 */
@Parcelize
data class PriceResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean,

    @SerializedName("data")
    @Expose
    var data: List<ItemPriceData> = ArrayList()

) :Parcelable {

    @Parcelize
    data class ItemPriceData (
        @SerializedName("item_id")
        @Expose
        var itemId : Int,
        @SerializedName("pricelvl_id")
        @Expose
        var pricelvlId : Int,
        @SerializedName("crc_id")
        @Expose
        var crcId : Int,
        @SerializedName("price1")
        @Expose
        var price1 : BigDecimal,
        @SerializedName("disc1exp")
        @Expose
        var disc1exp : String?,
        @SerializedName("price2")
        @Expose
        var price2 : BigDecimal,
        @SerializedName("disc2exp")
        @Expose
        var disc2exp : String?,
        @SerializedName("price3")
        @Expose
        var price3 : BigDecimal,
        @SerializedName("disc3exp")
        @Expose
        var disc3exp : String?,
        @SerializedName("pricedate")
        @Expose
        var pricedate : String,
        @SerializedName("usr_id")
        @Expose
        var usrId : Int,
        @SerializedName("lastpurcprice")
        @Expose
        var lastpurcprice : Int,
        @SerializedName("lastavgcost")
        @Expose
        var lastavgcost : String,
        @SerializedName("itemid")
        @Expose
        var itemid : String,
        @SerializedName("crcid")
        @Expose
        var crcid : String,
        @SerializedName("usrid")
        @Expose
        var usrid : String,
        @SerializedName("prclvlid")
        @Expose
        var prclvlid : String,
    ) : Parcelable
}