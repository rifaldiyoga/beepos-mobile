package com.bits.bee.bpmc.presentation.ui.info_kontak

import androidx.lifecycle.*
import com.bits.bee.bpmc.data.data_source.remote.response.RegisterResponse
import com.bits.bee.bpmc.domain.usecase.InfoKontakInteractor
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoKontakViewModel @Inject constructor(
    private val infoKontakInteractor: InfoKontakInteractor
): ViewModel() {
    private val eventChannel = Channel<InfoKontakViewModel.UIEvent>()
    val event = eventChannel.receiveAsFlow()

    private val _state = MutableStateFlow(InfoKontakState())
    fun observeState() = _state.asStateFlow()

    val state
        get() = _state.value

    private var registerResponse: MediatorLiveData<Resource<RegisterResponse>> = MediatorLiveData()
    fun observeRegisterResponse() = registerResponse as LiveData<Resource<RegisterResponse>>

    fun regisInfoKontak() {
        val source = infoKontakInteractor.infoKontak(state.nama, state.noWa, state.email, state.password, state.confPassword).asLiveData()
        registerResponse.addSource(source){
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

    fun validateInput() = viewModelScope.launch {
        _state.update {
            it.copy(isValid = state.nama.isNotEmpty()
                    && state.noWa.isNotEmpty()
                    && state.email.isNotEmpty()
                    && state.password.isNotEmpty()
                    && state.confPassword.isNotEmpty()
                    && state.password.equals(state.confPassword))
        }
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