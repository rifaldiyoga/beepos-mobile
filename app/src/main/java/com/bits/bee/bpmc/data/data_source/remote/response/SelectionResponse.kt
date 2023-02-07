package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SelectionResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,

    @SerializedName("data")
    @Expose
    var selectionModels: List<SelectionModel> = ArrayList()
) : Parcelable {

    @Parcelize
    data class SelectionModel (
        @SerializedName("id")
        @Expose
        var id: Int = 0,

        @SerializedName("code")
        @Expose
        var code: String = "",

        @SerializedName("name")
        @Expose
        var name: String = "",

        @SerializedName("note")
        @Expose
        var note: String = "",

        @SerializedName("isactive")
        @Expose
        var isActive: Boolean = false,

        @SerializedName("ismultiselect")
        @Expose
        var isMultiSelect: Boolean = false,

        @SerializedName("ismultiqty")
        @Expose
        var isMultiQty: Boolean = false,

        @SerializedName("created_at")
        @Expose
        var createdAt: String = "",

        @SerializedName("created_by")
        @Expose
        private val createdBy: Int? = null,

        @SerializedName("updated_by")
        @Expose
        private val updatedBy: Int? = null,

        @SerializedName("updated_at")
        @Expose
        private val updatedAt: String = "",

        ) : Parcelable
}