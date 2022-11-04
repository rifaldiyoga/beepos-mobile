package com.bits.bee.bpmc.presentation.ui.login_operator

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.response.CashierStatusResponse
import com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.UserRepository
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveLicenseUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.login.LoginUseCase
import com.bits.bee.bpmc.domain.usecase.login.operator.GetBranchUserUseCase
import com.bits.bee.bpmc.domain.usecase.login.operator.GetLicenseUseCase
import com.bits.bee.bpmc.domain.usecase.login.operator.GetSaleNotUploadedUseCase
import com.bits.bee.bpmc.domain.usecase.login.operator.GetUserPinUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.DetachCashierUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.UpdateActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.setting.UpdateUserUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 23/03/22.
 */
@HiltViewModel
class LoginOperatorViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val getBranchUserUseCase: GetBranchUserUseCase,
    private val getUserPinUseCase: GetUserPinUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val userRepository: UserRepository,
    @ApplicationContext val context: Context
): BaseViewModel<LoginOperatorState, LoginOperatorViewModel.UIEvent>() {

    init {
        state = LoginOperatorState()
    }

    private var loginResponse: MediatorLiveData<Resource<LoginResponse>> = MediatorLiveData()
    fun observeLoginResponse() = loginResponse as LiveData<Resource<LoginResponse>>

    private var branchUserResponse: MediatorLiveData<Resource<Any>> = MediatorLiveData()
    fun observebranchUserResponse() = branchUserResponse as LiveData<Resource<Any>>

    fun loadData() = viewModelScope.launch {

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
//        _state.update {
//            it.copy(
//                messageEmail = msg
//            )
//        }
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

    fun menuSinkron(){
        val source = getBranchUserUseCase().asLiveData()
        branchUserResponse.addSource(source){
            if (it != null) {
                branchUserResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    branchUserResponse.removeSource(source)
                }
            } else {
                branchUserResponse.removeSource(source)
            }
        }
    }


    fun checkPinUser(pin: String) = viewModelScope.launch {
        var userList: List<User> = mutableListOf()
        var userPin: User? = null
        getUserPinUseCase.invoke(pin).collect {
            it.let {
                userList = it
            }
        }
        if (userList.isEmpty()){
            // tidak valid
            state.mTimesWrong = state.mTimesWrong + 1
            eventChannel.send(UIEvent.ClearPIn)
            if (state.mTimesWrong == 2){
                eventChannel.send(UIEvent.RequetWarningPass)
            }

        }else{
            userPin = userList[0]
            if (pin == userPin.pin){
                //login Sukses
                userRepository.resetUsedUser()
                userPin.used = true
                updateUserUseCase(userPin)
                onSuccessLogin()
            }
        }
    }

    fun onClickLogin() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestLoginEmail)
    }

    fun onSuccessLogin() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToHome)
    }

    fun menuInfo() = viewModelScope.launch{
        eventChannel.send(UIEvent.RequestDialogInfo)
    }

    fun onClickSync() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDoSync)
    }

    sealed class UIEvent {
        object RequestLoginEmail :  UIEvent()
        object NavigateToHome : UIEvent()
        object RequestDialogInfo : UIEvent()
        object RequestDoSync : UIEvent()
        object RequestPilihKasir : UIEvent()
        object RequetWarningPass : UIEvent()
        object ClearPIn : UIEvent()
    }
}