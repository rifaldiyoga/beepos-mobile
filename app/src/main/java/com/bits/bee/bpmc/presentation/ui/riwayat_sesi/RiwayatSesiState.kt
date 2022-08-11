package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.Sesi

data class RiwayatSesiState(
    var search: String = "",
    var listPosses: PagingData<Posses>? = null,
    var selectFilter: String = "1 Minggu Terakhir",
    var listHistoryPosses: List<Posses>? = null,
    var sesiList: MutableList<Sesi>? = null,
    var isDesc: Boolean = false,
    var useFilter: Boolean = false
)