package com.bits.bee.bpmc.presentation.ui.detail_salesman

import com.bits.bee.bpmc.domain.model.*

/**
 * Created by aldi on 27/04/22.
 */
data class DetailSalesmanState(
    val srep : Srep? = null,
    val isInfoLainnya : Boolean = false,
    val bpAdddr: BpAddr? = null,
    val regency: Regency? = null,
    val district: District? = null
)
