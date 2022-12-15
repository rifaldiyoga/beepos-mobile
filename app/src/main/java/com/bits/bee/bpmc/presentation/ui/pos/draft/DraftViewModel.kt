package com.bits.bee.bpmc.presentation.ui.pos.draft

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bits.bee.bpmc.domain.model.FilterDate
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.usecase.common.DeleteSaleUseCase
import com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetLatestSaleUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.FilterUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 27/06/22.
 */
@HiltViewModel
class DraftViewModel @Inject constructor(
    private val getLatestSaleUseCase : GetLatestSaleUseCase,
    private val deleteSaleUseCase: DeleteSaleUseCase
): BaseViewModel<DraftState, DraftViewModel.UIEvent>() {

    private var _currentQuery : MutableStateFlow<String> = MutableStateFlow("")
    val currentQuery = _currentQuery.value

    var filterDate : MutableStateFlow<FilterDate> = MutableStateFlow(FilterUtils.getFilterDate(
        0,
        "",
        false
    ))

    init {
        state = DraftState()
    }

    @ExperimentalCoroutinesApi
    val draftList =  combine(
        _currentQuery,
        filterDate
    ){ (query, filter) ->
        QueryWithSort(query as String, filter as FilterDate)
    }.flatMapLatest {
        getLatestSaleUseCase(it.query, true, mutableListOf(), it.periode.startDate, it.periode.endDate).cachedIn(viewModelScope)
    }

    fun onFilterPeriode(filter : FilterDate) = viewModelScope.launch {
        filterDate.value = filter
    }

    fun onResetFilter() = viewModelScope.launch {
        filterDate.value = FilterUtils.getFilterDate(0, "", false)
    }

    fun onSearch(query: String) {
        _currentQuery.value = query
    }

    fun onItemClick(sale : Sale) = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDraft(sale))
    }


    fun onDeleteClick(sale : Sale) = viewModelScope.launch {
        deleteSaleUseCase(sale)
    }

    sealed class UIEvent {
        data class RequestDraft(val sale : Sale) : UIEvent()
    }

    data class QueryWithSort(
        val query: String,
        val periode : FilterDate
    )
}