package com.bits.bee.bpmc.presentation.ui.pos.cari_item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetItemByBarcodeUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 22/07/22.
 */

@HiltViewModel
class CariItemViewModel @Inject constructor(
    private val getActiveItemUseCase: GetActiveItemUseCase,
    private val getItemByBarcodeUseCase: GetItemByBarcodeUseCase,
    val savedStateHandle: SavedStateHandle
) : BaseViewModel<CariItemState, CariItemViewModel.UIEvent>() {

    var currentQuery: MutableStateFlow<String> = MutableStateFlow("")
        set(value) {
            field = value
            savedStateHandle["query"] = value
        }

    init {
        state = CariItemState()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val searchItemFlow = combine(
        currentQuery
    ) { (query) ->
        QueryWithSort(query)
    }.flatMapLatest {
        getActiveItemUseCase(itemGrpId = 1, bp = state.bp!!, query = it.query, usePid = state.usePid, channel = state.channel)
    }

    fun onScan(query: String) = viewModelScope.launch {
        val item = getItemByBarcodeUseCase(query, bp = state.bp!!, channel = state.channel).first()
        item?.let {
            onClickRetail(item)
        } ?: run {
            sendMessage("Scan tidak ditemukan!")
        }
    }

    fun onSearch(query: String) {
        currentQuery.value = query
        savedStateHandle["query"] = query
    }

    fun onClickRetail(item : Item) = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestItem(item))
    }

    sealed class UIEvent {
        data class RequestItem(val item : Item) : UIEvent()
    }

    data class QueryWithSort(
        val query: String,
    )
}