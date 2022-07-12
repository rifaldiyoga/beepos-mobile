package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize
import java.util.ArrayList

/**
 * Created by dwiki bits on 7/15/2018.
 */
@Parcelize
data class CcTypeResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,
    @SerializedName("data")
    @Expose
    var data: List<CcTypeModel> = ArrayList()
) : Parcelable {

    @Parcelize
    data class CcTypeModel (
        @SerializedName("cctype")
        @Expose
        var ccType: String = "",
        @SerializedName("cctypedesc")
        @Expose
        var ccTypeDesc: String = ""
    ) : Parcelable

}