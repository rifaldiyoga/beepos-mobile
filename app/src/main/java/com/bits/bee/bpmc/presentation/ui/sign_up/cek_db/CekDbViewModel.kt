package com.bits.bee.bpmc.presentation.ui.sign_up.cek_db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.remote.response.SignUpResponse
import com.bits.bee.bpmc.data.data_source.remote.response.CheckDbResponse
import com.bits.bee.bpmc.domain.repository.SignUpRepository
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 23/11/22
 */
@HiltViewModel
class CekDbViewModel @Inject constructor(
    private val signUpRepository: SignUpRepository
): BaseViewModel<Any, CekDbViewModel.UIEvent>() {

    init {
    }

    private var cekDbResponse: MediatorLiveData<Resource<CheckDbResponse>> = MediatorLiveData()
    fun observeCheckDbResponse() = cekDbResponse as LiveData<Resource<CheckDbResponse>>

    fun checkDb(serial : String) = viewModelScope.launch {
        val source = signUpRepository.postVerifDb(serial).asLiveData()
        cekDbResponse.addSource(source){
            if (it != null) {
                cekDbResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    cekDbResponse.removeSource(source)
                }
            } else {
                cekDbResponse.removeSource(source)
            }
        }
    }

    sealed class UIEvent {

    }

}