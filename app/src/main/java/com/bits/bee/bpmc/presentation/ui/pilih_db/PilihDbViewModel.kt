package com.bits.bee.bpmc.presentation.ui.pilih_db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.RetrofitClient
import androidx.lifecycle.*
import com.bits.bee.bpmc.data.data_source.remote.post.LicPost
import com.bits.bee.bpmc.data.data_source.remote.response.DbResponse
import com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse
import com.bits.bee.bpmc.domain.model.User
import com.bits.bee.bpmc.domain.usecase.common.InitialUseCase
import com.bits.bee.bpmc.domain.usecase.common.PostLicenseUseCase
import com.bits.bee.bpmc.domain.usecase.login.LoginUseCase
import com.bits.bee.bpmc.domain.usecase.login.PostDbUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.domain.usecase.pilih_db.GetUserBySecretSauce
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 04/03/22.
 */

@HiltViewModel
class PilihDbViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val initialUseCase: InitialUseCase,
    private val postDbUseCase: PostDbUseCase,
    private val postLicenseUseCase: PostLicenseUseCase,
    @ApplicationContext val context: Context,
    private val getUserBySecretSauce: GetUserBySecretSauce
) : BaseViewModel<PilihDbState, PilihDbViewModel.UIEvent>() {

    init {
        state = PilihDbState()
    }

    val initial = initialUseCase()

    private var loginResponse: MediatorLiveData<Resource<LoginResponse>> = MediatorLiveData()
    fun observeLoginResponse() = loginResponse as LiveData<Resource<LoginResponse>>



//    private var dbResponse: MediatorLiveData<Resource<DbResponse>> = MediatorLiveData()
//    fun observeDbResponse() = dbResponse as LiveData<Resource<DbResponse>>

    private var licResponse: MediatorLiveData<Resource<Any>> = MediatorLiveData()
    fun observeLicResponse() = licResponse as LiveData<Resource<Any>>

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

    fun initialData() = viewModelScope.launch{
        initialUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    showDialog("Inisialisasi Data")
                }
                Resource.Status.SUCCESS -> {
                    hideDialog()
                    onSuccessDb()
                }
                Resource.Status.ERROR -> {
                    hideDialog()
                }
            }
        }
    }

    fun postDb(dbName : String) = viewModelScope.launch {
        postDbUseCase(state.inputEmail, dbName).collect{
            when(it.status){
                Resource.Status.LOADING -> {
                    showDialog()
                }
                Resource.Status.SUCCESS -> {
                    hideDialog()
                    it.data?.let { data ->
                        if(data.status == "success"){
                            if(data.dataDb.isNotEmpty()) {
                                val apiKey = data.dataDb.firstOrNull()?.auth_key ?: ""
                                BeePreferenceManager.saveToPreferences(
                                    context,
                                    context.getString(R.string.api_key),
                                    apiKey
                                )
                                RetrofitClient.API_KEY = apiKey
                                postLicense()
                            }
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    hideDialog()
                }
            }
        }
    }

    fun postLicense() = viewModelScope.launch{
        val deviceName = BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.pref_nama_device), "") as String
        val version = Utils.getVersionName(context)
        postLicenseUseCase(state.inputEmail, deviceName, version).collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    showDialog("Validasi Lisensi")
                }
                Resource.Status.SUCCESS -> {
                    hideDialog()
                    it.data?.let {
                        initialData()
                    }
                }
                Resource.Status.ERROR -> {
                    hideDialog()
                }
            }
        }
    }

    fun doLincensing(authKey: String, deviceName: String) = viewModelScope.launch {
        var mUserList: List<User> = mutableListOf()
        var mUser: User? = null

        getUserBySecretSauce.invoke(state.inputEmail, authKey).collect {
            it.data?.let {
                mUserList = it
            }
        }

        if (mUserList.isEmpty()){
            mUser = User(
                username = state.inputEmail,
                userApiKey = "Bearer $authKey",
                pin = "",
                active = false,
                name = "",
                id = -1
            )
        }else{
            mUser = mUserList[0]
        }

        var lic = LicPost(
            email = mUser.username,
            deviceinfo = deviceName,
            type = BPMConstants.BPM_DEFAULT_LICENSE_TYPE,
            reactive = false,
            version = ""
        )

//        val source = postLicenseUseCase.invoke(lic).asLiveData()
//        licResponse.addSource(source){
//            if (it != null) {
//                licResponse.value = it
//                if (it.status !== Resource.Status.LOADING) {
//                    licResponse.removeSource(source)
//                }
//            } else {
//                licResponse.removeSource(source)
//            }
//        }

    }

//    fun onClickDb(dbName: LoginResponse.Db) = viewModelScope.launch {
//        val source = postDbUseCase(state.inputEmail, dbName.dbName).asLiveData()
//        dbResponse.addSource(source){
//            if (it != null) {
//                dbResponse.value = it
//                if (it.status !== Resource.Status.LOADING) {
//                    dbResponse.removeSource(source)
//                }
//            } else {
//                dbResponse.removeSource(source)
//            }
//        }
//
////        eventChannel.send(UIEvent.RequestDb)
//    }

    fun requestDb() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDb)
    }

    fun onSuccessDb() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPilihMode)
    }

    fun showDialog(msg : String = "") = viewModelScope.launch{
        eventChannel.send(UIEvent.ShowLoading(true, msg))
    }

    fun hideDialog() = viewModelScope.launch {
        eventChannel.send(UIEvent.ShowLoading(false))
    }

    sealed class UIEvent {
        data class ShowLoading(val isShow : Boolean, val msg : String = "") : UIEvent()
        object NavigateToPilihMode : UIEvent()
        object RequestDb : UIEvent()
    }

}