package com.bits.bee.bpmc.presentation.ui.walkthrough

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by aldi on 09/12/22
 */
class WalkThroughViewModel : BaseViewModel<WalkThroughState, WalkThroughViewModel.UIEvent>() {

    init {
        state = WalkThroughState()
    }

    fun onClickLanjut() = viewModelScope.launch {
        updateState(
            state.copy(
                pos = state.pos + 1
            )
        )
    }

    fun onClickBack() = viewModelScope.launch {
        updateState(
            state.copy(
                pos = state.pos - 1
            )
        )
    }

    sealed class UIEvent {
        object NavigateBack : UIEvent()
    }

}