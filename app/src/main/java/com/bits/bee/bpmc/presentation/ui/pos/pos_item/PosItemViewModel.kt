package com.bits.bee.bpmc.presentation.ui.pos.pos_item

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.usecase.common.GetRegUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 12/05/22.
 */
@HiltViewModel
class PosItemViewModel @Inject constructor(
    private val getRegUseCase: GetRegUseCase
): BaseViewModel<PosItemState, PosItemViewModel.UIEvent>() {

    init {
        state = PosItemState()
    }

    val regRound = getRegUseCase(BPMConstants.REG_ROUND)

    fun onReciveItemGroup(itemGroup: ItemGroup?) = viewModelScope.launch {
        updateState(
            state.copy(
                itemGroup = itemGroup
            )
        )
    }

    sealed class UIEvent {

    }
}