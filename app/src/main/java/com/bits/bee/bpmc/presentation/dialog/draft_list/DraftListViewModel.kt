package com.bits.bee.bpmc.presentation.dialog.draft_list

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.usecase.draft.GetLatestDraftUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.pos.draft.DraftViewModel
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

    fun onItemClick(sale : Sale) = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDraft(sale))
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
        data class RequestDraft(val sale : Sale) : UIEvent()
    }

}