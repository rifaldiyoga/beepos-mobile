package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.Posses

data class RiwayatSesiState(
    var search: String = "",
    var listPosses: PagingData<Posses>? = null
)