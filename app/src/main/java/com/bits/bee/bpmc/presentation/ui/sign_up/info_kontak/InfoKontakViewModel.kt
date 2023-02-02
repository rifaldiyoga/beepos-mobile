package com.bits.bee.bpmc.presentation.ui.sign_up.info_kontak

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.remote.response.SignUpResponse
import com.bits.bee.bpmc.domain.model.SignUp
import com.bits.bee.bpmc.domain.usecase.signup.PostSignUpUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.isContainsLowerCase
import com.bits.bee.bpmc.utils.isContainsNumber
import com.bits.bee.bpmc.utils.isContainsUpperCase
import com.bits.bee.bpmc.utils.isValidEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoKontakViewModel @Inject constructor(
    private val postSignUpUseCase: PostSignUpUseCase
): BaseViewModel<InfoKontakState, InfoKontakViewModel.UIEvent>() {

    init {
        state = InfoKontakState()
    }

    private var registerResponse: MediatorLiveData<Resource<SignUpResponse>> = MediatorLiveData()
    fun observeSignUpResponse() = registerResponse as LiveData<Resource<SignUpResponse>>

    fun onClickSignUp() = viewModelScope.launch{
        if(state.isValid) {
            var validPassword = state.password.length > 7
                    && state.password.isContainsUpperCase()
                    && state.password.isContainsLowerCase()
                    && state.password.isContainsNumber()

            var validConfPass = true
            var errConf = ""
            if(state.password != state.confPassword){
                errConf = "Konfirmasi password tidak sama"
                validConfPass = false
            }
            updateState(
                state.copy(
                    isShowWarnPass = !validPassword,
                    errorConfPass = errConf
                )
            )
            if(validPassword && validConfPass) {
                val signUp = SignUp(state.nama, state.noWa, state.email, state.password)
                val source = postSignUpUseCase(signUp).asLiveData()
                registerResponse.addSource(source) {
                    if (it != null) {
                        registerResponse.value = it
                        if (it.status !== Resource.Status.LOADING) {
                            registerResponse.removeSource(source)
                        }
                    } else {
                        registerResponse.removeSource(source)
                    }
                }
            }
        }
    }

    fun onPasswordChange(string : String) = viewModelScope.launch {
        updateState(
            state.copy(
                password = string
            )
        )
    }

    fun validate() {
        updateState(
            state.copy(isValid = state.nama.isNotEmpty()
                    && (state.noWa.isNotEmpty() && state.noWa.length >= 11)
                    && (state.email.isNotEmpty() && state.email.isValidEmail())
                    && state.password.isNotEmpty()
                    && state.confPassword.isNotEmpty()
            )
        )
    }

    fun onSuccesLanjut() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToOtp)
    }

    sealed class UIEvent {
        object RequestInfoKontak : UIEvent()
        object NavigateToOtp : UIEvent()
    }
}