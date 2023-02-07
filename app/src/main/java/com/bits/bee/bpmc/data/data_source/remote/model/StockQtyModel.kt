package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StockQtyModel(
    @SerializedName("status")
    @Expose
    var status: Boolean = false,
    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null
): Parcelable {

    @Parcelize
    data class Datum(
        @SerializedName("item_id")
        @Expose
        var itemId: Int? = null,
        @SerializedName("wh_id")
        @Expose
        var whId: Int? = null,
        @SerializedName("pid")
        @Expose
        var pid: String = "",
        @SerializedName("qty")
        @Expose
        var qty: String = "",
        @SerializedName("qtyx")
        @Expose
        var qtyx: String,
        @SerializedName("qtypo")
        @Expose
        var qtypo: String,
        @SerializedName("qtyxpo")
        @Expose
        var qtyxpo: String,
        @SerializedName("qtyso")
        @Expose
        var qtyso: String,
        @SerializedName("qtyxso")
        @Expose
        var qtyxso: String,
        @SerializedName("qtydefect")
        @Expose
        var qtydefect: String,
        @SerializedName("qtyxdefect")
        @Expose
        var qtyxdefect: String,
        @SerializedName("expdate")
        @Expose
        var expdate: String,
        @SerializedName("location")
        @Expose
        var location: String = "",
        @SerializedName("qtymin")
        @Expose
        var qtymin: String,
        @SerializedName("qtymax")
        @Expose
        var qtymax: String,
        @SerializedName("qtyreorder")
        @Expose
        var qtyreorder: String,
        @SerializedName("avgcost")
        @Expose
        var avgcost: String,
        @SerializedName("totcost")
        @Expose
        var totcost: String,
        @SerializedName("active")
        @Expose
        var active: Boolean,
        @SerializedName("opname_emp_id")
        @Expose
        var opnameEmpId: String? = null,
        @SerializedName("opname_date")
        @Expose
        var opnameDate: String? = null,
        @SerializedName("opname_usr_id")
        @Expose
        var opnameUsrId: String? =null,
        @SerializedName("_xt")
        @Expose
        var xt: Boolean,
        @SerializedName("subtotal")
        @Expose
        var subtotal: String,
        @SerializedName("itemid")
        @Expose
        var itemid: String,
        @SerializedName("whid")
        @Expose
        var whid: String,
        @SerializedName("lopempid")
        @Expose
        var lopempid: String? = null,
    ): Parcelable
}