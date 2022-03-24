package com.bits.bee.bpmc.ui.screen.pilih_kasir

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.bits.bee.bpmc.data.source.remote.response.CashierResponse
import com.bits.bee.bpmc.domain.usecase.CashierInteractor
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by aldi on 22/03/22.
 */
@HiltViewModel
class PilihKasirViewModel @Inject constructor(
    private val cashierInteractor: CashierInteractor
) : ViewModel() {

    private var cashierResponse: MediatorLiveData<Resource<CashierResponse>> = MediatorLiveData()
    fun observeCashierResponse() = cashierResponse as LiveData<Resource<CashierResponse>>

    fun getCashierList() {
        val source = cashierInteractor.getCashierList()
        cashierResponse.addSource(source){
            if (it != null) {
                cashierResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    cashierResponse.removeSource(source)
                }
            } else {
                cashierResponse.removeSource(source)
            }
        }
    }

}