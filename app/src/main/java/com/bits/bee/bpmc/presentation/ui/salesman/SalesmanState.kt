package com.bits.bee.bpmc.presentation.ui.salesman

import com.bits.bee.bpmc.domain.model.Srep

data class SalesmanState(
    var search: String = "",
    var listSrep: List<Srep>? = null
)