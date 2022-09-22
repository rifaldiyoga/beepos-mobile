package com.bits.bee.bpmc.presentation.ui.login_operator

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.lifecycle.*
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.model.CashierPost
import com.bits.bee.bpmc.data.data_source.remote.response.CashierStatusResponse
import com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveLicenseUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.login.LoginUseCase
import com.bits.bee.bpmc.domain.usecase.login.operator.*
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
    private val getSaleNotUploadedUseCase: GetSaleNotUploadedUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val getLicenseUseCase: GetLicenseUseCase,
    private val loginUseCase: LoginUseCase,
    private val getBranchUserUseCase: GetBranchUserUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val updateActiveCashierUseCase: UpdateActiveCashierUseCase,
    private val getUserPinUseCase: GetUserPinUseCase,
    private val getActiveLicenseUseCase: GetActiveLicenseUseCase,
    private val detachCashierUseCase: DetachCashierUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    @ApplicationContext val context: Context
): BaseViewModel<LoginOperatorState, LoginOperatorViewModel.UIEvent>() {

    private var mPosses: Posses? = null
    private var mLicense: License? = null
    private var mCashier: Cashier? = null

    init {
        state = LoginOperatorState()
    }

    private var loginResponse: MediatorLiveData<Resource<LoginResponse>> = MediatorLiveData()
    fun observeLoginResponse() = loginResponse as LiveData<Resource<LoginResponse>>

    private var branchUserResponse: MediatorLiveData<Resource<Any>> = MediatorLiveData()
    fun observebranchUserResponse() = branchUserResponse as LiveData<Resource<Any>>

    private var cashierStatusResponse: MediatorLiveData<Resource<CashierStatusResponse>> = MediatorLiveData()
    fun observeCashierStatusResponse() = cashierStatusResponse as LiveData<Resource<CashierStatusResponse>>

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

    fun menuReset() = viewModelScope.launch{
        getActivePossesUseCase.invoke().collect {
            it?.let {
                mPosses = it
            }
        }

        var listSale: List<Sale> = mutableListOf()
        getSaleNotUploadedUseCase.invoke().collect {
            it.data?.let {
                listSale = it
            }
        }
        if (listSale.size == 0){
            if (mPosses == null){
                confirmGantiKasir()
            }else{
                //tutup kasir dulu
            }
        }else{
            dialogHaventSync()
        }

    }

    fun deActiveStatusKasir() = viewModelScope.launch {

        getActiveCashierUseCase.invoke().collect {
            it?.let {
                mCashier = it
            }
        }

        val license : License = getActiveLicenseUseCase().first() ?: throw Exception("No Active License!")
//        getLicenseUseCase.invoke().collect {
//            it.data?.let {
//                mLicense = it.get(0)
//            }
//        }

//        val cashierPost = CashierPost(
//            cashierid = mCashier!!.id,
//            serial_number = mLicense!!.licNumber,
//            device_info = ""
//        )
//        val kode_device = Build.MANUFACTURER + Build.DEVICE + Build.ID + "-"
        val deviceName = BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.pref_nama_device), "") as String

        val source = detachCashierUseCase.invoke(mCashier!!, deviceName).asLiveData()
        cashierStatusResponse.addSource(source){
            if (it != null) {
                cashierStatusResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    cashierStatusResponse.removeSource(source)
                }
            } else {
                cashierStatusResponse.removeSource(source)
            }
        }

    }

    fun checkPinUser(pin: String) = viewModelScope.launch {
        var userList: List<User> = mutableListOf()
        var userPin: User? = null
        getUserPinUseCase.invoke(pin).collect {
            it.data?.let {
                userList = it
            }
        }
        if (userList.size == 0){
            // tidak valid
            state.mTimesWrong = state.mTimesWrong + 1
            Toast.makeText(context, "user tidak valid", Toast.LENGTH_SHORT).show()
            if (state.mTimesWrong == 2){
                eventChannel.send(UIEvent.RequetWarningPass)
            }

        }else{
            userPin = userList.get(0)
            if (pin.equals(userPin.pin)){
                //login Sukses
                userPin.active = true
                updateUserUseCase.invoke(userPin)
                onSuccessLogin()
            }
        }
    }

    fun updateCashier() = viewModelScope.launch {
        mCashier!!.isActive = false
        updateActiveCashierUseCase.invoke(mCashier!!)
        eventChannel.send(UIEvent.RequestPilihKasir)
    }

    fun onClickLogin() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestLoginEmail)
    }

    fun confirmGantiKasir() = viewModelScope.launch{
        eventChannel.send(UIEvent.RequestConfirmKasir)
    }

    fun dialogHaventSync() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDialogSync)
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
        object RequestConfirmKasir : UIEvent()
        object RequestDialogSync : UIEvent()
        object RequestLoginEmail :  UIEvent()
        object NavigateToHome : UIEvent()
        object RequestDialogInfo : UIEvent()
        object RequestDoSync : UIEvent()
        object RequestPilihKasir : UIEvent()
        object RequetWarningPass : UIEvent()
    }
}