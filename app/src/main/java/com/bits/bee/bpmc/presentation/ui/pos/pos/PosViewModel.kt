package com.bits.bee.bpmc.presentation.ui.pos.pos

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemGroupUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 19/04/22.
 */
@HiltViewModel
class PosViewModel @Inject constructor(
    private val getActiveItemGroupUseCase: GetActiveItemGroupUseCase,
    private val beePreferenceManager: BeePreferenceManager
): BaseViewModel<PosState, PosViewModel.UIEvent>() {

    var itemGroupList = getActiveItemGroupUseCase()

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