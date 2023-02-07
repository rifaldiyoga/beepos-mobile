package com.bits.bee.bpmc.presentation.ui.login

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse
import com.bits.bee.bpmc.domain.usecase.login.LoginUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 01/03/22.
 */

@HiltViewModel
class LoginViewModel @Inject constructor (
    private val loginUseCase: LoginUseCase,
    @ApplicationContext val context: Context
) : BaseViewModel<LoginViewState, LoginViewModel.UIEvent>() {

    init {
        state = LoginViewState()
    }


    fun login() : Flow<Resource<LoginResponse>> {
       return loginUseCase(state.email, state.password)
    }

    fun validateEmail() = viewModelScope.launch{
        val email = state.email
        var msg = ""

        updateState(
            state.copy(
                messageEmail = msg
            )
        )

        validateInput()
    }

    fun validatePassword() = viewModelScope.launch{
        val email = state.password
        var msg = ""


    }

    fun validateInput() = viewModelScope.launch {
        updateState(
            state.copy(isValid =
            state.password.isNotEmpty() && state.email.isNotEmpty() && Utils.isValidEmail(state.email))
        )
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