package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.FilterDate
import com.bits.bee.bpmc.domain.usecase.riwayat_sesi.*
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.FilterUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RiwayatSesiViewModel @Inject constructor(
    private val getFilterSortingUseCase: GetFilterSortingUseCase
): BaseViewModel<RiwayatSesiState, RiwayatSesiViewModel.UIEvent>() {

    val filterDate = MutableStateFlow(FilterUtils.getFilterDate(0, "", false))

    val sortDesc = MutableStateFlow(false)

    init {
        state = RiwayatSesiState()
    }

    val possesList = combine(
        filterDate,
        sortDesc
    ) { (filterDate, sortDesc) ->
        FilterWithSort(
            filterDate as FilterDate,
            sortDesc as Boolean
        )
    }.flatMapLatest {
        getFilterSortingUseCase(it.sortDesc, it.filterDate.startDate, it.filterDate.endDate)
    }

    fun onFilterPeriode(filterDate : FilterDate) {
        this.filterDate.value = filterDate
    }

    fun onSortChange(sortDesc: Boolean) {
        this.sortDesc.value = sortDesc
    }

    data class FilterWithSort(
        val filterDate: FilterDate,
        val sortDesc : Boolean
    )

    sealed class UIEvent {
        object RequestDialogFilter : UIEvent()
    }
}