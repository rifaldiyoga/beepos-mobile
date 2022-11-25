package com.bits.bee.bpmc.presentation.ui.sign_up.atur_pin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.remote.response.SetupPasswordResponse
import com.bits.bee.bpmc.data.data_source.remote.response.VerifSmsResponse
import com.bits.bee.bpmc.domain.repository.SignUpRepository
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 30/08/22.
 */
@HiltViewModel
class AturPinViewModel @Inject constructor(
) : BaseViewModel<AturPinState, AturPinViewModel.UIEvent>() {

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