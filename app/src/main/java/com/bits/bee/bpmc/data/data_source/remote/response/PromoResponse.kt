package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

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
        var branchId: String? = null,
        @SerializedName("isperiode")
        @Expose
        var isPeriode: Boolean = false,

        @SerializedName("startdate")
        @Expose
        var startDate: String? = null,

        @SerializedName("enddate")
        @Expose
        var endDate: String? = null,

        @SerializedName("istime")
        @Expose
        var isTime: Boolean = false,

        @SerializedName("starttime")
        @Expose
        var starttime: String? = null,

        @SerializedName("endtime")
        @Expose
        var endTime: String? = null,

        @SerializedName("isdow")
        @Expose
        var isDow: Boolean = false,

        @SerializedName("dowexp")
        @Expose
        var dowExp: String? = null,

        @SerializedName("isbpgrp1")
        @Expose
        var isBpgrp1: Boolean = false,

        @SerializedName("bpgrp1_id")
        @Expose
        var bpgrp1Id: String? = null,

        @SerializedName("isminamt")
        @Expose
        var isMinAmt: Boolean = false,

        @SerializedName("minamt")
        @Expose
        var minAmt: BigDecimal = BigDecimal.ZERO,

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
        var itemgrp1Id: String? = null,

        @SerializedName("istargetbrand")
        @Expose
        var isTargetBrand: Boolean = false,

        @SerializedName("brand_id")
        @Expose
        var brandId: String? = null,

        @SerializedName("istargetvendor")
        @Expose
        var isTargetVendor: Boolean = false,

        @SerializedName("vendor_id")
        @Expose
        var vendorId: String? = null,

        @SerializedName("isminqty")
        @Expose
        var isMinQty: Boolean = false,

        @SerializedName("minqty")
        @Expose
        var minQty: BigDecimal? = null,

        @SerializedName("priority")
        @Expose
        var priority: Int,

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


        @SerializedName("item_discexp")
        @Expose
        var itemDiscExp: String? = "",

        @SerializedName("promo_cat")
        @Expose
        var promoCat: String = "",

        @SerializedName("deal_item_id")
        @Expose
        var dealItemId: Int? = null,

        @SerializedName("item_price")
        @Expose
        var itemPrice: BigDecimal? = null,

        @SerializedName("maxqty")
        @Expose
        var maxQty: BigDecimal? = null,

        @SerializedName("ismaxqty")
        @Expose
        var isMaxQty: Boolean = false,

        @SerializedName("isminqtymultiply")
        @Expose
        var isMinQtyMultiply: Boolean = false,

        @SerializedName("ispriceoverride")
        @Expose
        var isPriceOverride: Boolean = false,

        @SerializedName("ismulti")
        @Expose
        var isMulti: Boolean = false,

        @SerializedName("deal_qty")
        @Expose
        var dealQty: BigDecimal? = null,

        @SerializedName("isdealsameitem")
        @Expose
        var isDealSameItem: Boolean = false
    ): Parcelable

}