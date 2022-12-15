package com.bits.bee.bpmc.presentation.ui.sign_up.otp

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.remote.response.SendOtpResponse
import com.bits.bee.bpmc.data.data_source.remote.response.VerifSmsResponse
import com.bits.bee.bpmc.domain.usecase.signup.PostSendOtpUseCase
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
    private val postVerifSmsUseCase: PostVerifSmsUseCase,
    private val postSendOtpUseCase: PostSendOtpUseCase,
) : BaseViewModel<OtpState, OtpViewModel.UIEvent>() {

    init {
        state = OtpState()
        startCountDown()
    }

    fun onInputPin(pin : String) = viewModelScope.launch {
        if(pin.length == 4){
            state.pin = pin
            delay(300)
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

    private var sendOtpResponse: MediatorLiveData<Resource<SendOtpResponse>> = MediatorLiveData()
    fun observeSendOtpResponse() = sendOtpResponse as LiveData<Resource<SendOtpResponse>>

    fun postSendOtp() = viewModelScope.launch {
        if(state.isSendOtp) {
            val source = postSendOtpUseCase("WA", state.regId).asLiveData()
            sendOtpResponse.addSource(source) {
                if (it != null) {
                    sendOtpResponse.value = it
                    if (it.status !== Resource.Status.LOADING) {
                        sendOtpResponse.removeSource(source)
                    }
                } else {
                    sendOtpResponse.removeSource(source)
                }
            }
            startCountDown()
        }
    }

    fun startCountDown() {
        val time = object : CountDownTimer(30000, 1000){
            override fun onTick(p0: Long) {
                updateState(
                    state.copy(
                        isSendOtp = false,
                        countDown = p0
                    )
                )
            }

            override fun onFinish() {
                updateState(
                    state.copy(
                        isSendOtp = true
                    )
                )
            }
        }
        time.start()
    }

    fun onSuccess() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToAturPin)
    }

    sealed class UIEvent {
        object NavigateToAturPin : UIEvent()
    }

}