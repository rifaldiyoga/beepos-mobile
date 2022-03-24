package com.bits.bee.bpmc.ui.screen.login

import androidx.lifecycle.*
import com.bits.bee.bpmc.data.source.remote.response.LoginResponse
import com.bits.bee.bpmc.domain.usecase.LoginInteractor
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 01/03/22.
 */

@HiltViewModel
class LoginViewModel @Inject constructor (
    private val loginInteractor: LoginInteractor
) : ViewModel() {

    private val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    private val _state : MutableLiveData<LoginState> = MutableLiveData(LoginState())
    fun observeState() = _state as LiveData<LoginState>

    val state
        get() = _state.value!!

    private var loginResponse: MediatorLiveData<Resource<LoginResponse>> = MediatorLiveData()
    fun observeLoginResponse() = loginResponse as LiveData<Resource<LoginResponse>>

    fun login() {
        val source = loginInteractor.login(state.email, state.password)
        loginResponse.addSource(source){
            if (it != null) {
                loginResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    loginResponse.removeSource(source)
                }
            } else {
                loginResponse.removeSource(source)
            }
        }
    }

    fun setState() = viewModelScope.launch {
    }

    fun onClickLogin() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestLogin)
    }

    fun onSuccessLogin() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToNamaDevice)
    }

    sealed class UIEvent {
        object RequestLogin : UIEvent()
        object NavigateToNamaDevice : UIEvent()
    }
}