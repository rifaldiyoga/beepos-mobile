package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by Med
 */
@Parcelize
data class GrpPrvResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,
    @SerializedName("data")
    @Expose
    var data: List<GrpPrvModel> = ArrayList()
): Parcelable{

    @Parcelize
    data class GrpPrvModel (
        @SerializedName("id")
        @Expose
        var id: Int = -1,
        @SerializedName("obj_code")
        @Expose
        var objCode: String = "",
        @SerializedName("acstype")
        @Expose
        var acsType: String = "",
        @SerializedName("enabled")
        @Expose
        var enabled: Boolean = false,
        @SerializedName("acsval")
        @Expose
        var acsVal: String = "",
        @SerializedName("grp_id")
        @Expose
        var grpId: Int = -1,
        @SerializedName("updated_at")
        @Expose
        var updatedAt: String = "",
        @SerializedName("code")
        @Expose
        var code: String = "",
        @SerializedName("up_code")
        @Expose
        var upCode: String = "",
        @SerializedName("modul_code")
        @Expose
        var modulCode: String = "",
        @SerializedName("name")
        @Expose
        var name: String = "",
        @SerializedName("mnemonic")
        @Expose
        var mnemonic: String = "",
        @SerializedName("level")
        @Expose
        var level: Int = -1,
    ) :Parcelable
}