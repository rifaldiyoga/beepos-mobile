package com.bits.bee.bpmc.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by aldi on 04/03/22.
 */
abstract class BaseViewModel<State, UIEvent>(
) : ViewModel() {

    val eventChannel = Channel<UIEvent>(Channel.BUFFERED)
    val event = eventChannel.receiveAsFlow()

    val errorChannel = Channel<String>()
    val error = errorChannel.receiveAsFlow()

    private val _state : MutableStateFlow<State?> = MutableStateFlow(null)
    fun viewStates(): StateFlow<State?> = _state

    var state : State
        get() = _state.value
            ?: throw UninitializedPropertyAccessException("state was queried before being initialized")
        set(value) {
            if(_state.value == value){
                _state.value = null
            }
            _state.value = value
        }

    fun updateState(s: State) = viewModelScope.launch{
        _state.update {
            s
        }
    }
}