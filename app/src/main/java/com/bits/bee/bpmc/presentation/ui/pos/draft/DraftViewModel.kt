package com.bits.bee.bpmc.presentation.ui.pos.draft

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.usecase.common.DeleteSaleUseCase
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
 * Created by aldi on 27/06/22.
 */
@HiltViewModel
class DraftViewModel @Inject constructor(
    private val getLatestSaleUseCase : GetLatestSaleUseCase,
    private val deleteSaleUseCase: DeleteSaleUseCase
): BaseViewModel<DraftState, DraftViewModel.UIEvent>() {

    private var _currentQuery : MutableStateFlow<String> = MutableStateFlow("")
    val currentQuery = _currentQuery.value
    init {
        state = DraftState()
    }

    @ExperimentalCoroutinesApi
    val draftList =  combine(
        _currentQuery
    ){ (query) ->
        QueryWithSort(query)
    }.flatMapLatest {
        getLatestSaleUseCase(it.query, true).cachedIn(viewModelScope)
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
    )
}