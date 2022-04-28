package com.bits.bee.bpmc.presentation.ui.login

import android.content.Context
import androidx.lifecycle.*
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.source.remote.response.LoginResponse
import com.bits.bee.bpmc.domain.usecase.LoginInteractor
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 01/03/22.
 */

@HiltViewModel
class LoginViewModel @Inject constructor (
    private val loginInteractor: LoginInteractor,
    @ApplicationContext val context: Context
) : ViewModel() {

    private val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    private val _state = MutableStateFlow(LoginViewState())
    var state = _state.asStateFlow()

    private var loginResponse: MediatorLiveData<Resource<LoginResponse>> = MediatorLiveData()
    fun observeLoginResponse() = loginResponse as LiveData<Resource<LoginResponse>>

    fun login() {
        val source = loginInteractor.login(_state.value.email, state.value.password).asLiveData()
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

    fun validateEmail() = viewModelScope.launch{
        val email = state.value.email
        var msg = ""
        if(email.isEmpty())
            msg = context.getString(R.string.email_tidak_boleh_kosong)
        if(!Utils.isValidEmail(email))
            msg = "Email tidak valid!"
        _state.update {
            it.copy(
                messageEmail = msg
            )
        }
        validateInput()
    }

    fun validatePassword() = viewModelScope.launch{
        val email = state.value.password
        var msg = ""
        if(email.isEmpty())
            msg = context.getString(R.string.email_tidak_boleh_kosong)

        _state.update {
            it.copy(
                messagePassword = msg
            )
        }
        validateInput()
    }

    private fun validateInput() = viewModelScope.launch {
        _state.update {
            it.copy(isValid = it.messagePassword.isEmpty() && it.messageEmail.isEmpty())
        }
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