package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.local.model.PmtdEntity
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 29/03/22.
 */
@Parcelize
data class PmtdResponse (
    @SerializedName("status")
    var status:Boolean = false,
    @SerializedName("message")
    var msg : String = "",
    @SerializedName("data")
    var data : Data
): Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var data : MutableList<PmtdModel> = mutableListOf()
    ) : Parcelable

    @Parcelize
    data class PmtdModel(
        @SerializedName(PmtdEntity.ID)
        val id : Int,
        @SerializedName(PmtdEntity.IDX)
        val idx : Int,
        @SerializedName(PmtdEntity.CODE)
        val code : String,
        @SerializedName(PmtdEntity.NAME)
        val name: String,
        @SerializedName(PmtdEntity.CASH_ID)
        val cashId : Int,
        @SerializedName(PmtdEntity.MDREXP)
        val mdrExp : Int,
        @SerializedName(PmtdEntity.MDRACC)
        val mdrAcc : Int,
        @SerializedName(PmtdEntity.SURCEXP)
        val surExp : Int,
        @SerializedName(PmtdEntity.SURCACC)
        val surAcc : Int,
        @SerializedName(PmtdEntity.BRANCH_ID)
        val branchId : Int,
        @SerializedName(PmtdEntity.SETTLEDAYS)
        val settleDays : Int,
        @SerializedName(PmtdEntity.CASH_NAME)
        val cashName : String,
        @SerializedName(PmtdEntity.BRANCH_NAME)
        val branchName : String,
    ) : Parcelable {


    }

}