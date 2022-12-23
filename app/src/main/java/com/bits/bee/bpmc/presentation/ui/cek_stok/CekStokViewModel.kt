package com.bits.bee.bpmc.presentation.ui.cek_stok

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.domain.usecase.cek_stok.GetItemStockUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.upload_manual.GetItemByIdUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CekStokViewModel @Inject constructor(
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getItemStockUseCase: GetItemStockUseCase,
    private val getItemByIdUseCase: GetItemByIdUseCase,
): BaseViewModel<CekStokState, CekStokViewModel.UIEvent>() {

    private var querySearch=""

    init {
        state = CekStokState()
    }

    fun loadStock() = viewModelScope.launch {
        val cashier = getActiveCashierUseCase.invoke().first()
        getItemStockUseCase.invoke(Integer.parseInt(""+cashier!!.whId)).collectLatest {
            when(it.status){
                Resource.Status.LOADING -> {
                    eventChannel.send(UIEvent.RequestWaitDialog)
                }
                Resource.Status.SUCCESS -> {
                    eventChannel.send(UIEvent.HideDialog)
                    it.data?.let {
                        updateState(
                            state.copy(stockList = it)
                        )
                    }
                }
                Resource.Status.ERROR -> {
                    it.message
                }
                Resource.Status.NOINTERNET -> {
                    eventChannel.send(UIEvent.HideDialog)
                    eventChannel.send(UIEvent.NoInternetDialog)
                }
            }
        }
    }

    fun initStock(list: List<Stock>) = viewModelScope.launch {
        val itemListItm = mutableListOf<Item>()
        var items: Item? = null
        for (stock in list){
            getItemByIdUseCase.invoke(stock.itemId).collect {
                it?.let {
                    items = it
                }
            }
            itemListItm.add(items!!)
        }

        updateState(
            state.copy(
                itemsList = itemListItm
            )
        )

    }

    fun filterStock(query: String) = viewModelScope.launch {
        querySearch = query
//        val regex = """(?i)("${query}").*""".toRegex()
        val regexx = "(?i)($query).*".toRegex()
        var mItemClone = mutableListOf<Item>()
        for (item in state.itemsList!!) {
            if (item.name1.matches(regexx)) {
                mItemClone.add(item)
            }
        }
        updateState(
            state.copy(
                itemListResult = mItemClone
            )
        )
    }

    fun sort(desc: Boolean, data: List<Stock>) = viewModelScope.launch {
        var items: Item? = null
        var listSortItem = mutableListOf<Item>()
        var listSortStock = mutableListOf<Stock>()
        if (desc){
            listSortStock = data.sortedByDescending { it.id }.toMutableList()
        }else{
            listSortStock = data.sortedBy { it.id }.toMutableList()
        }

        for (stock in listSortStock){
            getItemByIdUseCase.invoke(stock.itemId).collect {
                it?.let {
                    items = it
                }
            }
            listSortItem.add(items!!)
        }
        updateState(
            state.copy(
                itemsList = listSortItem
            )
        )
    }

    fun resetStock() = viewModelScope.launch {
        querySearch = ""
        var mItemClone = mutableListOf<Item>()
        updateState(
            state.copy(
                itemListResult = mItemClone
            )
        )
    }

    sealed class UIEvent{
        object RequestWaitDialog : UIEvent()
        object HideDialog : UIEvent()
        object NoInternetDialog : UIEvent()
    }
}