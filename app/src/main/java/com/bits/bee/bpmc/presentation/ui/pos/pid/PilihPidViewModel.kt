package com.bits.bee.bpmc.presentation.ui.pos.pid

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.domain.usecase.pos.GetPidByItemUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 04/08/22.
 */

@HiltViewModel
class PilihPidViewModel @Inject constructor(
    private val getPidByItemUseCase: GetPidByItemUseCase
) : BaseViewModel<PilihPidState, PilihPidViewModel.UIEvent>() {

    init {
        state = PilihPidState()
    }

    fun onItemClick(stock: Stock) = viewModelScope.launch{
        state.item?.let {
            eventChannel.send(UIEvent.NavigateToAddItem(it, stock))
        }
    }

    fun loadData() = viewModelScope.launch {
        state.item?.let {
            getPidByItemUseCase(it).collect {
                when(it.status){
                    Resource.Status.LOADING -> {

                    }
                    Resource.Status.SUCCESS -> {
                        it.data?.let {
                            updateState(
                                state.copy(stockList = it)
                            )
                        }
                    }
                    Resource.Status.ERROR -> {
                        it.message
                    }
                }
            }
        }
    }

    sealed class UIEvent {
        data class NavigateToAddItem(val item : Item, val stock : Stock) : UIEvent()
    }

}