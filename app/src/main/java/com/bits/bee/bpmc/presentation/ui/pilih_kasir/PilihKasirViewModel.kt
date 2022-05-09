package com.bits.bee.bpmc.presentation.ui.pilih_kasir

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bits.bee.bpmc.data.source.local.model.Cashier
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.GetLatestCashierUseCase
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by aldi on 22/03/22.
 */
@HiltViewModel
class PilihKasirViewModel @Inject constructor(
    private val getLatestCashierUseCase: GetLatestCashierUseCase
) : ViewModel() {

    private var cashierResponse: MediatorLiveData<Resource<List<Cashier>>> = MediatorLiveData()
    fun observeCashierResponse() = cashierResponse as LiveData<Resource<List<Cashier>>>

    fun getCashierList() {
        val source = getLatestCashierUseCase().asLiveData()
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