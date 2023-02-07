package com.bits.bee.bpmc.presentation.ui.cari_kecamatan

import com.bits.bee.bpmc.domain.model.CityPopuler
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.domain.model.Regency

data class CariKecamatanState(
    var ff: String ="",
    var cityPopuler: CityPopuler? = null,
    var regency: Regency? = null,
    var listDistrict: List<District>? = null
)