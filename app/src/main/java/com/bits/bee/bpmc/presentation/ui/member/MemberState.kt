package com.bits.bee.bpmc.presentation.ui.member

import com.bits.bee.bpmc.domain.model.Bp

data class MemberState(
    var search: String = "",
    var listBp: List<Bp>? = null
)