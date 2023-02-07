package com.bits.bee.bpmc.data.data_source.remote.post

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 09/03/22.
 */
@Parcelize
data class LoginPost(
    var username : String = "",
    var password : String = ""
) : Parcelable