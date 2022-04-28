package com.bits.bee.bpmc.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * Created by aldi on 04/03/22.
 */
abstract class BaseViewModel<State, UIEvent>(
) : ViewModel() {

    val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    val _state : MutableStateFlow<State?> = MutableStateFlow(null)
    var state : State
        get() = _state.value
            ?: throw UninitializedPropertyAccessException("state was queried before being initialized")
        set(value) {
            if(_state.value == value){
                _state.value = null
            }
            _state.value = value
        }

}