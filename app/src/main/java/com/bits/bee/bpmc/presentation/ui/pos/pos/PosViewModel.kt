package com.bits.bee.bpmc.presentation.ui.pos.pos

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 19/04/22.
 */
@HiltViewModel
class PosViewModel @Inject constructor(
    private val itemGroupRepository: ItemGroupRepository
): BaseViewModel<PosState, PosViewModel.UIEvent>() {

    var itemGroupList = itemGroupRepository.getActiveItemGroupNotAddOnList()

    init {
        state = PosState()
    }

    fun onClickInvoice() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestInvoice)
    }

    fun onClickAdd() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSearch)
    }


    sealed class UIEvent {
        object RequestInvoice : UIEvent()
        object NavigateToSearch : UIEvent()
    }
}