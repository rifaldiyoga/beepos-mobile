package com.bits.bee.bpmc.presentation.ui.pos.draft

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.draft.GetLatestDraftUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 27/06/22.
 */
@HiltViewModel
class DraftViewModel @Inject constructor(
    private val getLatestDraftUseCase: GetLatestDraftUseCase
): BaseViewModel<DraftState, DraftViewModel.UIEvent>() {

    init {
        state = DraftState()
    }

    fun loadDraft() = viewModelScope.launch {
        getLatestDraftUseCase().collect {
            updateState(state.copy(saleList = it))
        }
    }

    sealed class UIEvent {

    }
}