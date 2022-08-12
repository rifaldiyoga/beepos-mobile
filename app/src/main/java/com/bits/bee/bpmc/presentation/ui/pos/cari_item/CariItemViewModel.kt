package com.bits.bee.bpmc.presentation.ui.pos.cari_item

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemUseCase
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
    private val getActiveItemUseCase: GetActiveItemUseCase
) : BaseViewModel<CariItemState, CariItemViewModel.UIEvent>() {

    private var currentQuery: MutableStateFlow<String> = MutableStateFlow("")

    init {
        state = CariItemState()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val searchItemFlow = combine(
        currentQuery
    ){ (query) ->
        QueryWithSort(query)
    }.flatMapLatest {
        getActiveItemUseCase(itemGrpId = 1, bp = state.bp!!, query = it.query, usePid = state.usePid).cachedIn(viewModelScope)
    }

    fun onSearch(query: String) {
        currentQuery.value = query
    }

    fun onClickRetail(item : Item) = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestItem(item))
    }

    fun loadItem(bp : Bp, query : String) = viewModelScope.launch {
        getActiveItemUseCase(itemGrpId = 1, bp = bp, query = query)
            .cachedIn(viewModelScope)
            .collectLatest {
                updateState(
                    state.copy(
                        itemList = it
                    )
                )
            }
    }

    sealed class UIEvent {
        data class RequestItem(val item : Item) : UIEvent()
    }

    data class QueryWithSort(
        val query: String,
    )
}