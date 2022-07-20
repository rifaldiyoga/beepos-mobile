package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.local.model.TaxEntity
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 29/03/22.
 */
@Parcelize
data class TaxResponse (
    @SerializedName("status")
    var status:Boolean = false,
    @SerializedName("message")
    var msg : String = "",
    @SerializedName("data")
    var data : MutableList<TaxModel> = mutableListOf()
): Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var data : MutableList<TaxModel> = mutableListOf()
    ) : Parcelable

    @Parcelize
    data class TaxModel(
        @SerializedName("code")
        val code : String,
        @SerializedName("name")
        val name : String,
        @SerializedName("expr")
        val expr : String,
        @SerializedName("active")
        val isActive : Boolean,
        @SerializedName("isdefault")
        val isDefault : Boolean,
    ) : Parcelable {

        fun toTax() : TaxEntity {
            return TaxEntity(-1, code, name, expr, isActive, isDefault)
        }

    }

}