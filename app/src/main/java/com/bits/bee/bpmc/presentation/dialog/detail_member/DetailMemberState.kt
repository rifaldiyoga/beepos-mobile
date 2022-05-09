package com.bits.bee.bpmc.presentation.dialog.detail_member

import com.bits.bee.bpmc.domain.model.Bp

/**
 * Created by aldi on 27/04/22.
 */
data class DetailMemberState(
    val bp : Bp? = null,
    val isInfoLainnya : Boolean = false
)
