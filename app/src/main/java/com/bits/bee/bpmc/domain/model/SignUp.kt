package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.remote.post.SignUpPost
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 30/08/22.
 */
@Parcelize
data class SignUp (
    var nama: String = "",
    var noWa : String = "",
    var email: String = "",
    var password: String = "",
    var confPassword: String = "",
    var namaPerusahaan : String = "",
    var bidangUsah : String = "",
    var cityId : String = "",
    var address : String = "",
    var step : Int = 1,
    var regId : String? = null,
    var utm_source: String="",
    var utm_medium: String="",
    var utm_campaign: String="",
    var utm_term: String="",
    var utm_content: String = ""
) : Parcelable