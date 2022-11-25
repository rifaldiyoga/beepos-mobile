package com.bits.bee.bpmc.presentation.ui.transaksi_penjualan

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.domain.model.FilterDate
import com.bits.bee.bpmc.domain.model.Sale
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
 * Created by aldi on 23/06/22.
 */
@HiltViewModel
class TransaksiPenjualanViewModel @Inject constructor(
    private val getLatestSaleUseCase: GetLatestSaleUseCase
) : BaseViewModel<TransaksiPenjualanState, TransaksiPenjualanViewModel.UIEvent>() {

    private var currentQuery : MutableStateFlow<String> = MutableStateFlow("")

    var channelList : MutableStateFlow<List<Channel>> = MutableStateFlow(mutableListOf())

    var filterDate : MutableStateFlow<FilterDate> = MutableStateFlow(FilterUtils.getFilterDate(0, ""))

    private var _activeSale : MutableStateFlow<Sale?> = MutableStateFlow(null)
    val activeSale : MutableStateFlow<Sale?>
        get() = _activeSale

    init {
        state = TransaksiPenjualanState()
    }

    @ExperimentalCoroutinesApi
    val saleList =  combine(
        currentQuery,
        channelList,
        filterDate
    ){ (query, channel, filter) ->
        QueryWithSort(
            query as String,
            channel as List<Channel>,
            filter as FilterDate
        )
    }.flatMapLatest {
        getLatestSaleUseCase(it.query, false, it.channelList, it.periode.startDate, it.periode.endDate)
    }

    fun onFilterPeriode(filter : FilterDate) = viewModelScope.launch {
        filterDate.value = filter
    }

    fun onFilterChannel(channel : List<Channel>) = viewModelScope.launch {
        channelList.value = channel
    }

    fun onSearch(query : String) = viewModelScope.launch {
        currentQuery.value = query
    }

    fun onResetFilter() = viewModelScope.launch {
        channelList.value = mutableListOf()
        filterDate.value = FilterUtils.getFilterDate(0, "")
    }

    fun updateActiveSale(sale: Sale) = viewModelScope.launch {
        _activeSale.emit(sale)
    }

    sealed class UIEvent{

    }

    data class QueryWithSort(
        val query: String,
        val channelList : List<Channel>,
        val periode : FilterDate
    )

}