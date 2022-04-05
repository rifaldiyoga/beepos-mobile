package com.bits.bee.bpmc.data.source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.source.local.model.Pmtd
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
        @SerializedName(Pmtd.ID)
        val id : Int,
        @SerializedName(Pmtd.IDX)
        val idx : Int,
        @SerializedName(Pmtd.CODE)
        val code : String,
        @SerializedName(Pmtd.NAME)
        val name: String,
        @SerializedName(Pmtd.CASH_ID)
        val cashId : Int,
        @SerializedName(Pmtd.MDREXP)
        val mdrExp : Int,
        @SerializedName(Pmtd.MDRACC)
        val mdrAcc : Int,
        @SerializedName(Pmtd.SURCEXP)
        val surExp : Int,
        @SerializedName(Pmtd.SURCACC)
        val surAcc : Int,
        @SerializedName(Pmtd.BRANCH_ID)
        val branchId : Int,
        @SerializedName(Pmtd.SETTLEDAYS)
        val settleDays : Int,
        @SerializedName(Pmtd.CASH_NAME)
        val cashName : String,
        @SerializedName(Pmtd.BRANCH_NAME)
        val branchName : String,
    ) : Parcelable {

        fun toPmtd() : Pmtd {
            return Pmtd(id, idx, code, name, cashId, mdrExp, mdrAcc, surExp, surAcc, branchId, settleDays, cashName, branchName)
        }

    }

}