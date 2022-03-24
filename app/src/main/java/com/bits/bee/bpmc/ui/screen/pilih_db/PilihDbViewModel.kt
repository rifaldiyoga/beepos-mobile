package com.bits.bee.bpmc.ui.screen.pilih_db

import androidx.lifecycle.*
import com.bits.bee.bpmc.data.source.remote.response.LoginResponse
import com.bits.bee.bpmc.domain.usecase.LoginInteractor
import com.bits.bee.bpmc.ui.screen.login.LoginViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

/**
 * Created by aldi on 04/03/22.
 */

@HiltViewModel
class PilihDbViewModel @Inject constructor(
    private val loginInteractor: LoginInteractor,
    private val state : SavedStateHandle
) : ViewModel() {

    private val eventChannel = Channel<LoginViewModel.UIEvent>()
    val event = eventChannel.receiveAsFlow()

    var inputEmail = state.get<String>("inputEmail") ?: "hafis@beeaccounting.com"
        set(value) {
            field = value
            state.set("inputEmail", value)
        }

    var inputPassword = state.get<String>("inputPassword") ?: "Nanda123"
        set(value) {
            field = value
            state.set("inputPassword", value)
        }

    private var loginResponse: MediatorLiveData<Resource<LoginResponse>> = MediatorLiveData()
    fun observeLoginResponse() = loginResponse as LiveData<Resource<LoginResponse>>

    fun login() {
        val source = loginInteractor.login(inputEmail, inputPassword)
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

    sealed class UIEvent {
        object RequestDatabase : UIEvent()
    }

}