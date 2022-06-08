package com.bits.bee.bpmc.presentation.ui.cari_kota

import com.bits.bee.bpmc.domain.model.City

/**
 * Created by aldi on 13/05/22.
 */
data class CariKotaState (
    var cari : String = "",
    var cityListRekomendasi : List<City> = mutableListOf(),
    var cityListCari : List<City> = mutableListOf()
)