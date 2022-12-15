package com.bits.bee.bpmc.presentation.ui.rekap_produk

import android.annotation.SuppressLint
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.FilterDate
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.usecase.pos.GetPidByItemUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_produk.FilterSearchItemUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_produk.LoadCariItemsUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_produk.QueryRekapProdukUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.FilterUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RekapProdukViewModel @Inject constructor(
    private val queryRekapProdukUseCase: QueryRekapProdukUseCase,
    private val loadCariItemsUseCase: LoadCariItemsUseCase,
    private val filterSearchItemUseCase: FilterSearchItemUseCase,
    private val getPidByItemUseCase: GetPidByItemUseCase
): BaseViewModel<RekapProdukState, RekapProdukViewModel.UIEvent>() {

    private var currentQuery : MutableStateFlow<String> = MutableStateFlow("")

    var filterDate : MutableStateFlow<FilterDate> = MutableStateFlow(FilterUtils.getFilterDate(
        0,
        "",
        false
    ))

    init {
        state = RekapProdukState()
    }

    @ExperimentalCoroutinesApi
    val itemList = combine(
            filterDate,
            currentQuery
    ){(filter, query) ->
        QueryWithSort(
                filter as FilterDate,
                query as String
        )
    }.flatMapLatest {
        queryRekapProdukUseCase(it.periode.startDate, it.periode.endDate, it.query)
    }

    fun onFilterPeriode(filter : FilterDate, query: String) = viewModelScope.launch {
        filterDate.value = filter
        updateState(
                state.copy(
                        start = filter.startDate,
                        end = filter.endDate,
                )
        )
//        val listItem = queryRekapProdukUseCase.invoke(filter.startDate, filter.endDate, query)
//        updateState(
//                state.copy(
//                        itemList = listItem,
//                        start = filter.startDate,
//                        end = filter.endDate,
//                        selectPos = filter.selectedPos
//                )
//        )
    }

    fun searching(query: String) = viewModelScope.launch {
        currentQuery.value = query
    }

    @SuppressLint("SuspiciousIndentation")
    fun cariItems(query: String, prclv: Int, filter: FilterDate) = viewModelScope.launch {
        filterDate.value = filter
        updateState(
            state.copy(
                searchQuery = query
            )
        )

        val newResult = loadCariItemsUseCase.invoke(state.searchQuery, prclv, filter.startDate, filter.endDate)
          updateState(
              state.copy(
                  itemListResult = newResult
              )
          )
    }

    fun filterItems(dataItem: List<Item>, filter: FilterDate) = viewModelScope.launch {
        filterDate.value = filter
        val itemListItm = mutableListOf<Item>()
        var mListSaled: List<Saled>? = null

        for (checkItem in dataItem){
            filterSearchItemUseCase.invoke(checkItem.id, filter.startDate, filter.endDate).collect{
                    mListSaled = it
            }
            for (data in mListSaled ?: mutableListOf()){
                checkItem.subtotal = checkItem.subtotal.add(data.subtotal)
                checkItem.qty = checkItem.qty.add(data.qty)
            }
            itemListItm.add(checkItem)
        }
        updateState(
            state.copy(
                resultFilteritem = itemListItm
            )
        )

    }

    fun getValuePid() = viewModelScope.launch {
        getPidByItemUseCase.invoke(state.item!!).collect{
            it.data?.let {
                updateState(
                    state.copy(
                        listPid = it
                    )
                )
            }
        }
    }

    fun showDialog() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDialogFilter)
    }

    sealed class UIEvent{
        object RequestDialogFilter: UIEvent()
    }

    data class QueryWithSort(
            val periode : FilterDate,
            val query: String
    )
}