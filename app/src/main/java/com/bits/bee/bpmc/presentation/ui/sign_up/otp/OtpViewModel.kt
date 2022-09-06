package com.bits.bee.bpmc.presentation.ui.sign_up.otp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.remote.response.VerifSmsResponse
import com.bits.bee.bpmc.domain.usecase.signup.PostVerifSmsUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 30/08/22.
 */

@HiltViewModel
class OtpViewModel @Inject constructor(
    private val postVerifSmsUseCase: PostVerifSmsUseCase
) : BaseViewModel<OtpState, OtpViewModel.UIEvent>() {

    init {
        state = OtpState()
    }

    fun onInputPin(pin : String) = viewModelScope.launch {
        if(pin.length == 4){
            delay(500)
            postVerifSms()
        }
    }

    private var registerResponse: MediatorLiveData<Resource<VerifSmsResponse>> = MediatorLiveData()
    fun observeVerifSmsResponse() = registerResponse as LiveData<Resource<VerifSmsResponse>>

    fun postVerifSms() = viewModelScope.launch {
        val source = postVerifSmsUseCase(state.pin, state.regId).asLiveData()
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

    fun onSuccess() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToAturPin)
    }

    sealed class UIEvent {
        object NavigateToAturPin : UIEvent()
    }

}