package com.bits.bee.bpmc.data.source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.source.local.model.Cashier
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
    var data : Data
):Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var data : MutableList<Datum> = mutableListOf()
    ) : Parcelable

    @Parcelize
    data class Datum(
        @SerializedName("id")
        val id : Int = -1,
        @SerializedName("code")
        val code : String = "",
        @SerializedName("cashier")
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
        val isActive : Boolean = false,
        @SerializedName("status")
        val status : Boolean = false,
    ) : Parcelable {

        fun toCashierEntity() : Cashier {
            return Cashier(id, code, cashierName, branchId, cashBranchId, whId, cashId, isActive, status)
        }

    }

}