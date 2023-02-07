package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.local.model.CashierEntity
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
    var data : MutableList<CashierModel> = mutableListOf()
):Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var cashierModels : MutableList<CashierModel> = mutableListOf()
    ) : Parcelable

    @Parcelize
    data class CashierModel(
        @SerializedName("id")
        val id : Int = -1,
        @SerializedName("code")
        val code : String = "",
        @SerializedName("name")
        val cashierName: String = "",
        @SerializedName("branch_id")
        val branchId : Long = -1,
        @SerializedName("cashbranch_id")
        val cashBranchId : Int = -1,
        @SerializedName("wh_id")
        val whId : Long = -1,
        @SerializedName("cash_id")
        val cashId : Long = -1,
        @SerializedName("active")
        var isActive : Boolean = false,
    ) : Parcelable {

    }

}