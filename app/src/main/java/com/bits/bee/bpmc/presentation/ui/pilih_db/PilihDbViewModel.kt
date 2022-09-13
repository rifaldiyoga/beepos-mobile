package com.bits.bee.bpmc.presentation.ui.pilih_db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.RetrofitClient
import com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse
import com.bits.bee.bpmc.domain.usecase.common.InitialUseCase
import com.bits.bee.bpmc.domain.usecase.common.PostLicenseUseCase
import com.bits.bee.bpmc.domain.usecase.login.LoginUseCase
import com.bits.bee.bpmc.domain.usecase.login.PostDbUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
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
    @ApplicationContext val context: Context
) : BaseViewModel<PilihDbState, PilihDbViewModel.UIEvent>() {

    init {
        state = PilihDbState()
    }

    val initial = initialUseCase()

    private var loginResponse: MediatorLiveData<Resource<LoginResponse>> = MediatorLiveData()
    fun observeLoginResponse() = loginResponse as LiveData<Resource<LoginResponse>>



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

    fun onClickDb() = viewModelScope.launch {
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