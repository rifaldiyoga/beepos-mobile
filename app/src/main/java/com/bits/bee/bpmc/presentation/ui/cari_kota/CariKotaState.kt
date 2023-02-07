package com.bits.bee.bpmc.presentation.ui.cari_kota

import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.domain.model.Regency

/**
 * Created by aldi on 13/05/22.
 */
data class CariKotaState (
    var cari : String = "",
    var cityListRekomendasi : List<City> = mutableListOf(),
    var cityListCari : List<City> = mutableListOf(),
    var nameList: List<String>? = null,
    var errorMsg: String = "",
    var regencyListCari: List<Regency> = mutableListOf(),
    var etKota: String? = null,
    var district: District? = null

)