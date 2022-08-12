package com.bits.bee.bpmc.presentation.ui.pos.pos_item

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 12/05/22.
 */
@HiltViewModel
class PosItemViewModel @Inject constructor(
    private val getActiveItemUseCase: GetActiveItemUseCase
): BaseViewModel<PosItemState, PosItemViewModel.UIEvent>() {

    init {
        state = PosItemState()
    }

    var itemFlow : Flow<PagingData<Item>> = MutableSharedFlow(1)

    fun loadItem(bp : Bp) = viewModelScope.launch {
        getActiveItemUseCase(state.itemGroup?.id ?: -1, state.priceLvlId, bp).collectLatest {
            updateState(
                state.copy(
                    itemList = it
                )
            )
        }
    }

    fun onReciveItemGroup(itemGroup: ItemGroup) = viewModelScope.launch {
        updateState(
            state.copy(
                itemGroup = itemGroup
            )
        )
    }

    sealed class UIEvent {

    }
}