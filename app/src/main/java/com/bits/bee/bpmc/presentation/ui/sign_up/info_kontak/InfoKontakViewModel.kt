package com.bits.bee.bpmc.presentation.ui.sign_up.info_kontak

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.remote.response.SignUpResponse
import com.bits.bee.bpmc.domain.model.SignUp
import com.bits.bee.bpmc.domain.usecase.signup.PostSignUpUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
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

    suspend fun postSignUp() : Flow<Resource<SignUpResponse>> {
        val signUp = SignUp(state.nama, state.noWa, state.email, state.password)
         return postSignUpUseCase(signUp)
    }

    fun validateInput() = viewModelScope.launch {
        updateState(
            state.copy(isValid = state.nama.isNotEmpty()
                    && state.noWa.isNotEmpty()
                    && state.email.isNotEmpty()
                    && state.password.isNotEmpty()
                    && state.confPassword.isNotEmpty()
                    && state.password == state.confPassword
            )
        )
    }

    fun onClickLanjut() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestInfoKontak)
    }

    fun onSuccesLanjut() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToOtp)
    }

    sealed class UIEvent {
        object RequestInfoKontak : UIEvent()
        object NavigateToOtp : UIEvent()
    }
}