package com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir

import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.User

data class RekapSesiState(
    var posses: Posses ?= null,
    var user: User? = null
)