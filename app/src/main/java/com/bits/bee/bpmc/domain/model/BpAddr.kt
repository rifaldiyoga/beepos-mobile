package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.BpAddrEntity
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class BpAddr(
    var id : Int? = null,
    var bpId : Int? = null,
    var name: String,
    var greeting: String?,
    var address : String,
    var phone : String,
    var zipCode : String?,
    var email : String?,
    var note : String?,
    var isBillAddr : Boolean,
    var isShipAddr : Boolean,
    var isMainAddr : Boolean,
    var provinceCode : String,
    var regencyCode : String,
    var cityId : Int = 0,
    var districtCode : String,
//    var createdAt : Date?,
//    var updatedAt : Date?,
): Parcelable {
}