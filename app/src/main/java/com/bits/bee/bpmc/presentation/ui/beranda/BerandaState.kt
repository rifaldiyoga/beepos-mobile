package com.bits.bee.bpmc.presentation.ui.beranda

import com.bits.bee.bpmc.domain.model.License

/**
 * Created by aldi on 03/06/22.
 */
data class BerandaState (
    var isBukaKasir : Boolean = false,
    var activeLicense : License? = null
)