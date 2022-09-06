package com.bits.bee.bpmc.presentation.ui.sign_up.atur_pin

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by aldi on 30/08/22.
 */
class AturPinViewModel : BaseViewModel<AturPinState, AturPinViewModel.UIEvent>() {

    init {
        state = AturPinState()
    }

    fun onPinInput(pin : String) = viewModelScope.launch {
        updateState(
            state.copy(
                pin = pin
            )
        )
        if(pin.length == 6){
            onPinFilled()
        }
    }

    fun onPinFilled() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToUlangPin(state.pin))
    }

    sealed class UIEvent {
        data class NavigateToUlangPin(val pin : String) : UIEvent()
    }
}