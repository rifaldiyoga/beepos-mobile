package com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.RetrofitClient
import com.bits.bee.bpmc.data.data_source.remote.response.DbResponse
import com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse
import com.bits.bee.bpmc.data.data_source.remote.response.SetupPasswordResponse
import com.bits.bee.bpmc.domain.repository.SignUpRepository
import com.bits.bee.bpmc.domain.usecase.login.LoginUseCase
import com.bits.bee.bpmc.domain.usecase.login.PostDbUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 30/08/22.
 */
@HiltViewModel
class UlangiPinViewModel @Inject constructor(
    private val signUpRepository: SignUpRepository,
    private val postDbUseCase: PostDbUseCase,
    private val loginUseCase: LoginUseCase,
) : BaseViewModel<UlangiPinState, UlangiPinViewModel.UIEvent>() {

    init {
        state = UlangiPinState()
    }

    private var setupPasswordResponse: MediatorLiveData<Resource<SetupPasswordResponse>> = MediatorLiveData()
    fun observeSetupPasswordResponse() = setupPasswordResponse as LiveData<Resource<SetupPasswordResponse>>

    fun onPinInput(pin : String) = viewModelScope.launch {
        state.pin = pin
        if(pin.length == 6) {
            if(pin == state.pinBefore){
                onPinFilled()
            } else {
                eventChannel.send(UIEvent.PinNotSame)
            }
        }
    }


    fun onPinFilled() = viewModelScope.launch {
        val source = signUpRepository.postSetupPassword(state.authKey, state.password, state.pin).asLiveData()
        setupPasswordResponse.addSource(source){
            if (it != null) {
                setupPasswordResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    setupPasswordResponse.removeSource(source)
                }
            } else {
                setupPasswordResponse.removeSource(source)
            }
        }
    }

    private var loginResponse: MediatorLiveData<Resource<LoginResponse>> = MediatorLiveData()
    fun observeLoginResponse() = loginResponse as LiveData<Resource<LoginResponse>>

    fun login() {
        val source = loginUseCase(state.email, state.password).asLiveData()
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


    private var dbResponse: MediatorLiveData<Resource<DbResponse>> = MediatorLiveData()
    fun observeDbResponse() = dbResponse as LiveData<Resource<DbResponse>>

    fun postDb(dbName : String) = viewModelScope.launch {
        val source = postDbUseCase(state.email, dbName).asLiveData()
        dbResponse.addSource(source){
            if (it != null) {
                dbResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    dbResponse.removeSource(source)
                }
            } else {
                dbResponse.removeSource(source)
            }
        }
    }

    fun onSuccess() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToAturProduk)
    }

    sealed class UIEvent {
        object NavigateToAturProduk : UIEvent()
        object PinNotSame : UIEvent()
    }

}