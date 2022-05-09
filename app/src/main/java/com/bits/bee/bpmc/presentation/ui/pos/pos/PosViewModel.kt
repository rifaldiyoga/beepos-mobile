package com.bits.bee.bpmc.presentation.ui.pos.pos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveChannelUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemGroupUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
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

    var itemGroupList = getActiveItemGroupUseCase.invoke()

    fun onClickInvoice() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestInvoice)
    }

    sealed class UIEvent {
        object RequestInvoice : UIEvent()
    }
}