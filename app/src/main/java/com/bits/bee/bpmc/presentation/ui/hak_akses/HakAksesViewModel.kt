package com.bits.bee.bpmc.presentation.ui.hak_akses

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse
import com.bits.bee.bpmc.domain.helper.PrivilegeHelper
import com.bits.bee.bpmc.domain.model.User
import com.bits.bee.bpmc.domain.usecase.login.LoginUseCase
import com.bits.bee.bpmc.domain.usecase.login.operator.GetUserPinUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.login_operator.LoginOperatorViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 01/11/22
 */
@HiltViewModel
class HakAksesViewModel @Inject constructor(
    private val getUserPinUseCase: GetUserPinUseCase,
    private val privilegeHelper: PrivilegeHelper,
    private val loginUseCase: LoginUseCase,
    @ApplicationContext val context: Context
): BaseViewModel<HakAksesState, HakAksesViewModel.UIEvent>() {

    init {
        state = HakAksesState()
    }

    private var loginResponse: MediatorLiveData<Resource<LoginResponse>> = MediatorLiveData()
    fun observeLoginResponse() = loginResponse as LiveData<Resource<LoginResponse>>

    fun checkPinUser(pin: String) = viewModelScope.launch {
        val user = getUserPinUseCase.invoke(pin).first().firstOrNull()

        user?.let {
            if(privilegeHelper.hasAccess(BPMConstants.BPM_PRIVILEGE_OBJ, state.acsType, it.id)) {
                sendMessage("Terauth")
                onSuccessValidate()
            } else {
                sendMessage("User tidak Memiliki akses")
                eventChannel.send(UIEvent.ClearPin)
            }
        } ?: run {
            state.mTimesWrong = state.mTimesWrong + 1
//            sendMessage("Tidak terauth")
            eventChannel.send(UIEvent.ClearPin)
            if (state.mTimesWrong == 2){
                eventChannel.send(UIEvent.RequetWarningPass)
            }
        }
    }

    fun validateEmail() = viewModelScope.launch{
        val email = state.email
        var msg = ""
        if(email.isEmpty())
            msg = context.getString(R.string.email_tidak_boleh_kosong)
        if(!Utils.isValidEmail(email))
            msg = "Email tidak valid!"
        updateState(
            state.copy(
                messageEmail = msg
            )
        )
        validateInput()
    }

    fun validatePassword() = viewModelScope.launch {
        val email = state.password
        var msg = ""
        if(email.isEmpty())
            msg = context.getString(R.string.email_tidak_boleh_kosong)

        updateState(
            state.copy(
                messagePassword = msg
            )
        )
        validateInput()
    }

    private fun validateInput() = viewModelScope.launch{
        updateState(
            state.copy(
                isValid = state.messagePassword.isEmpty() && state.messageEmail.isEmpty()
            )
        )
    }

    fun loginEmail(){
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

    fun onSuccessValidate() = viewModelScope.launch {
        eventChannel.send(UIEvent.SuccessValididation)
    }

    sealed class UIEvent {
        object ClearPin : UIEvent()
        object RequetWarningPass : UIEvent()
        object SuccessValididation : UIEvent()
    }

}