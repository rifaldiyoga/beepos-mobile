package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 21/10/22
 */
@Parcelize
data class GopayPost (
    @SerializedName("order_id")
    @Expose
    var order_id: String,
    @SerializedName("total")
    @Expose
    var total: String,
    @SerializedName("item_details")
    @Expose
    var item_details: List<ItemDetail> = mutableListOf()
) : Parcelable {

    @Parcelize
    data class ItemDetail(
        @SerializedName("id")
        @Expose
        var id: Int,
        @SerializedName("price")
        @Expose
        var price: String,
        @SerializedName("quantity")
        @Expose
        var quantity: String,
        @SerializedName("name")
        @Expose
        var name: String
    ) : Parcelable

    @Parcelize
    data class CustomerDetails(
        @SerializedName("first_name")
        @Expose
        var first_name: String,
        @SerializedName("last_name")
        @Expose
        var last_name: String,
        @SerializedName("email")
        @Expose
        var email: String,
        @SerializedName("phone")
        @Expose
        var phone: String
    ) : Parcelable

}