package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Utm(
    var utm_source: String="",
    var utm_medium: String="",
    var utm_campaign: String="",
    var utm_term: String="",
    var utm_content: String = ""
) : Parcelable