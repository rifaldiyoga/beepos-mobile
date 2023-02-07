package com.bits.bee.bpmc.presentation.dialog.detail_member

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.BpAddr
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.domain.model.Regency

/**
 * Created by aldi on 27/04/22.
 */
data class DetailMemberState(
    val bp : Bp? = null,
    val isInfoLainnya : Boolean = false,
    val bpAdddr: BpAddr? = null,
    val regency: Regency? = null,
    val district: District? = null
)
