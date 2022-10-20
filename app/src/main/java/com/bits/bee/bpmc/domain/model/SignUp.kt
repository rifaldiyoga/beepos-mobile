package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.remote.post.SignUpPost
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 30/08/22.
 */
@Parcelize
data class SignUp (
    var nama: String,
    var noWa : String,
    var email: String,
    var password: String,
    var namaPerusahaan : String? = "",
    var bidangUsah : String? = "",
    var cityId : String? = "",
    var address : String? = "",
    var step : Int = 1,
    var regId : Int? = null,
    var utm_source: String? = null,
    var utm_medium: String? = null,
    var utm_campaign: String? = null,
    var utm_term: String? = null,
    var utm_content: String? = null
) : Parcelable