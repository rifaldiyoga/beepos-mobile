package com.bits.bee.bpmc.presentation.ui.pos.pos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveChannelUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemGroupUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 19/04/22.
 */
@HiltViewModel
class PosViewModel @Inject constructor(
    private val getActiveItemGroupUseCase: GetActiveItemGroupUseCase,
): BaseViewModel<PosState, PosViewModel.UIEvent>() {

    private val _stateSearch : MutableStateFlow<String?> = MutableStateFlow(null)
    fun searchStates(): StateFlow<String?> = _stateSearch

    var itemGroupList = getActiveItemGroupUseCase.invoke()

    fun onClickInvoice() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestInvoice)
    }

    fun onClickDraft() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToDraft)
    }

    fun onClickDiskonNota() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToDiskonNota)
    }

    fun onClickSearch() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSearch)
    }

    sealed class UIEvent {
        object RequestInvoice : UIEvent()
        object NavigateToDraft : UIEvent()
        object NavigateToDiskonNota : UIEvent()
        object NavigateToSearch : UIEvent()
    }
}