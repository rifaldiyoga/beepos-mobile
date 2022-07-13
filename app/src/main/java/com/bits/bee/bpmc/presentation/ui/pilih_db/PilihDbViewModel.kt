package com.bits.bee.bpmc.presentation.ui.pilih_db

import androidx.lifecycle.*
import com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse
import com.bits.bee.bpmc.domain.usecase.common.InitialUseCase
import com.bits.bee.bpmc.domain.usecase.login.LoginUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.login.LoginViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 04/03/22.
 */

@HiltViewModel
class PilihDbViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val initialUseCase: InitialUseCase

) : BaseViewModel<PilihDbState, PilihDbViewModel.UIEvent>() {

    init {
        state = PilihDbState()
    }

    val initial = initialUseCase()

    private var loginResponse: MediatorLiveData<Resource<LoginResponse>> = MediatorLiveData()
    fun observeLoginResponse() = loginResponse as LiveData<Resource<LoginResponse>>

    private var initialResponse: MediatorLiveData<Resource<Any>> = MediatorLiveData()
    fun observeInitialResponse() = initialResponse as LiveData<Resource<Any>>

    fun login() {
        val source = loginUseCase(state.inputEmail, state.inputPassword).asLiveData()
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

    fun initialData() {
        val source = initialUseCase().asLiveData()
        initialResponse.addSource(source){
            if (it != null) {
                initialResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    initialResponse.removeSource(source)
                }
            } else {
                initialResponse.removeSource(source)
            }
        }
    }

    fun onClickDb() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDb)
    }

    fun onSuccessDb() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPilihMode)
    }

    sealed class UIEvent {
        object NavigateToPilihMode : UIEvent()
        object RequestDb : UIEvent()
    }

}