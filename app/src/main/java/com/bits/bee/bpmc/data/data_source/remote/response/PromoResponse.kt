package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by Med.
 */
@Parcelize
class PromoResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,
    @SerializedName("data")
    @Expose
    var data: List<DataPromo> = ArrayList()
) : Parcelable {

    @Parcelize
    data class DataPromo (
        @SerializedName("id")
        @Expose
        var id: Int = -1,
        @SerializedName("isactive")
        @Expose
        var isActive: Boolean = false,
        @SerializedName("isbranch")
        @Expose
        var isBranch: Boolean = false,
        @SerializedName("branch_id")
        @Expose
        var branchId: String = "",
        @SerializedName("isperiode")
        @Expose
        var isPeriode: Boolean = false,

        @SerializedName("startdate")
        @Expose
        var startDate: String = "",

        @SerializedName("enddate")
        @Expose
        var endDate: String = "",

        @SerializedName("istime")
        @Expose
        var isTime: Boolean = false,

        @SerializedName("starttime")
        @Expose
        var starttime: String = "",

        @SerializedName("endtime")
        @Expose
        var endTime: String = "",

        @SerializedName("isdow")
        @Expose
        var isDow: Boolean = false,

        @SerializedName("dowexp")
        @Expose
        var dowExp: String = "",

        @SerializedName("isbpgrp1")
        @Expose
        var isBpgrp1: Boolean = false,

        @SerializedName("bpgrp1_id")
        @Expose
        var bpgrp1Id: String = "",

        @SerializedName("minamt")
        @Expose
        private var minAmt: Int? = null,

        @SerializedName("istargetitem")
        @Expose
        var isTargetItem: Boolean = false,

        @SerializedName("item_id")
        @Expose
        var itemId: Int? = null,

        @SerializedName("istargetitgrp1")
        @Expose
        var isTargetItgrp1: Boolean = false,

        @SerializedName("itemgrp1_id")
        @Expose
        var itemgrp1Id: String = "",

        @SerializedName("istargetbrand")
        @Expose
        var isTargetBrand: Boolean = false,

        @SerializedName("brand_id")
        @Expose
        var brandId: String = "",

        @SerializedName("istargetvendor")
        @Expose
        var isTargetVendor: Boolean = false,

        @SerializedName("vendor_id")
        @Expose
        var vendorId: String = "",

        @SerializedName("isminqty")
        @Expose
        var isMinQty: Boolean = false,

        @SerializedName("minqty")
        @Expose
        private var minQty: Int? = null,

        @SerializedName("priority")
        @Expose
        var priority: Int? = null,

        @SerializedName("offertype")
        @Expose
        var offerType: String = "",

        @SerializedName("code")
        @Expose
        var code: String = "",

        @SerializedName("type")
        @Expose
        var type: String = "",

        @SerializedName("name")
        @Expose
        var promoName: String = "",

        @SerializedName("note")
        @Expose
        var note: String = "",

        @SerializedName("isminamt")
        @Expose
        private var isMinAmt: Boolean = false,

        @SerializedName("item_discexp")
        @Expose
        var itemDiscExp: String = "",

        @SerializedName("promo_cat")
        @Expose
        var promoCat: String = "",

        @SerializedName("deal_item_id")
        @Expose
        var dealItemId: Int? = null,

        @SerializedName("item_price")
        @Expose
        var itemPrice: Int? = null,

        @SerializedName("maxqty")
        @Expose
        var maxQty: Int? = null,

        @SerializedName("ismaxqty")
        @Expose
        private var isMaxQty: Boolean = false,

        @SerializedName("isminqtymultiply")
        @Expose
        var isMinQtyMultiply: Boolean = false,
    ): Parcelable

}