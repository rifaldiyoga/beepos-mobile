package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.FilterDate
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.Sesi
import com.bits.bee.bpmc.utils.FilterUtils

data class RiwayatSesiState(
    var search: String = "",
    var listPosses: PagingData<Posses>? = null,
    var selectFilter: FilterDate = FilterUtils.getFilterDate(0, "", false),
    var listHistoryPosses: List<Posses>? = null,
    var sesiList: MutableList<Sesi>? = null,
    var isDesc: Boolean = false,
    var useFilter: Boolean = false
)