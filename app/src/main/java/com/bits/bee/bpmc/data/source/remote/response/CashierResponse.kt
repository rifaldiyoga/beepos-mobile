package com.bits.bee.bpmc.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class CashierResponse (
    @SerializedName("status")
    var status:Boolean = false,
    @SerializedName("message")
    var msg : String = "",
    @SerializedName("data")
    var data : Data? = null
):Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var data : MutableList<Cashier> = mutableListOf()
    ) : Parcelable

    @Parcelize
    data class Cashier(
        @SerializedName("id")
        val id : Int,
        @SerializedName("code")
        val code : String,
        @SerializedName("cashier")
        val cashierName: String,
        @SerializedName("branch_id")
        val branchId : Long,
        @SerializedName("cashbranch_id")
        val cashBranchId : Int,
        @SerializedName("wh_id")
        val whId : Long,
        @SerializedName("cash_id")
        val cashId : Long,
        @SerializedName("active")
        val isActive : Boolean,
        @SerializedName("status")
        val status : Boolean,
    ) : Parcelable

}