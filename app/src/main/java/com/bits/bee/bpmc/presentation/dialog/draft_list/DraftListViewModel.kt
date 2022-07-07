package com.bits.bee.bpmc.presentation.dialog.draft_list

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.draft.GetLatestDraftUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 24/06/22.
 */
@HiltViewModel
class DraftListViewModel @Inject constructor(
    private val getLatestDraftUseCase: GetLatestDraftUseCase
) : BaseViewModel<DraftListDialogState, DraftListViewModel.UIEvent>() {

    init {
        state = DraftListDialogState()
    }

    fun getDraftList() = viewModelScope.launch {
        getLatestDraftUseCase().collect {
            updateState(
                state.copy(
                    saleList = it
                )
            )
        }
    }

    sealed class UIEvent {

    }

}