package com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by aldi on 30/08/22.
 */
class UlangiPinViewModel : BaseViewModel<UlangiPinState, UlangiPinViewModel.UIEvent>() {

    init {
        state = UlangiPinState()
    }

    fun onPinInput(pin : String) = viewModelScope.launch {
        if(pin.length == 6) {
            if(pin == state.pinBefore){
                onPinFilled()
            } else {
                eventChannel.send(UIEvent.PinNotSame)
            }
        }
    }


    fun onPinFilled() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToAturProduk)
    }

    sealed class UIEvent {
        object NavigateToAturProduk : UIEvent()
        object PinNotSame : UIEvent()
    }

}