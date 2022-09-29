package com.bits.bee.bpmc.presentation.ui.transaksi_penjualan

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetLatestSaleUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
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

    private var _activeSale : MutableStateFlow<Sale?> = MutableStateFlow(null)
    val activeSale : MutableStateFlow<Sale?>
        get() = _activeSale

    init {
        state = TransaksiPenjualanState()
    }

    @ExperimentalCoroutinesApi
    val saleList =  combine(
        currentQuery
    ){ (query) ->
        QueryWithSort(query)
    }.flatMapLatest {
        getLatestSaleUseCase(it.query, false).cachedIn(viewModelScope)
    }

    fun onSearch(query : String) = viewModelScope.launch {
        currentQuery.value = query
    }

    fun updateActiveSale(sale: Sale) = viewModelScope.launch {
        _activeSale.emit(sale)
    }

    sealed class UIEvent{

    }

    data class QueryWithSort(
        val query: String,
    )

}