package com.bits.bee.bpmc.presentation.ui.pos.pos_item

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.update
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

    var itemList : Flow<Resource<List<Item>>> = MutableSharedFlow(1)

    fun loadItem() = viewModelScope.launch {
        itemList = getActiveItemUseCase(state.itemGroup?.id ?: -1, state.priceLvlId)
    }

    fun onReciveItemGroup(itemGroup: ItemGroup) = viewModelScope.launch {
        _state.update {
            it!!.copy(
                itemGroup = itemGroup
            )
        }
    }

    sealed class UIEvent {

    }
}