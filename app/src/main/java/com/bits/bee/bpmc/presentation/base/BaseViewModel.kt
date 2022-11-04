package com.bits.bee.bpmc.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Created by aldi on 04/03/22.
 */
abstract class BaseViewModel<State, UIEvent> : ViewModel() {

    val eventChannel = Channel<UIEvent>(Channel.BUFFERED)
    val event = eventChannel.receiveAsFlow()

    val msgChannel = Channel<String>()
    val msg = msgChannel.receiveAsFlow()

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

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        sendMessage(throwable.message)
    }

    fun sendMessage(msg : String?) = viewModelScope.launch {
        msgChannel.send(msg ?: "")
    }


}