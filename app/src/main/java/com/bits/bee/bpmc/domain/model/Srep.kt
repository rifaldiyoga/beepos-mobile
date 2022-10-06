package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Srep(
    var id : Int?,
    var code: String,
    var name: String,
    var cityCode: String?,
    var address: String?,
    var zipCode: String?,
    var phone: String?,
    var mobile : String?,
    var email : String?,
) : Parcelable