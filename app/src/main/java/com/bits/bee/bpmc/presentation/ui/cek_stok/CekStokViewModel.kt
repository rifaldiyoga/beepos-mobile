package com.bits.bee.bpmc.presentation.ui.cek_stok

import com.bits.bee.bpmc.domain.usecase.cek_stok.GetItemStockUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class CekStokViewModel @Inject constructor(
    private val getItemStockUseCase: GetItemStockUseCase,
): BaseViewModel<CekStokState, CekStokViewModel.UIEvent>() {

    var currentQuery : MutableStateFlow<String> = MutableStateFlow("")

    var sortDesc : MutableStateFlow<Boolean> = MutableStateFlow(false)

    init {
        state = CekStokState()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val stockList =  combine(
        currentQuery,
        sortDesc,
    ){ (query, sortDesc) ->
        QueryWithSort(
            query as String,
            sortDesc as Boolean,
        )
    }.flatMapLatest {
        getItemStockUseCase( it.query, it.sortDesc)
    }

    fun onQueryChange(q : String) {
        currentQuery.value = q
    }

    fun onSortDesc(b : Boolean) {
        sortDesc.value = !b
    }

    data class QueryWithSort(
        val query: String,
        val sortDesc : Boolean,
    )

    sealed class UIEvent{
        object RequestWaitDialog : UIEvent()
        object HideDialog : UIEvent()
        object NoInternetDialog : UIEvent()
    }
}