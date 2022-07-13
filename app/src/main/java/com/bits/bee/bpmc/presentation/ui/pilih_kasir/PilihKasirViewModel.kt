package com.bits.bee.bpmc.presentation.ui.pilih_kasir

import androidx.lifecycle.*
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.GetLatestCashierUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.UpdateActiveCashierUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 22/03/22.
 */
@HiltViewModel
class PilihKasirViewModel @Inject constructor(
    private val getLatestCashierUseCase: GetLatestCashierUseCase,
    private val updateActiveCashierUseCase: UpdateActiveCashierUseCase
) : BaseViewModel<PilihKasirState, PilihKasirViewModel.UIEvent>() {

    private var cashierEntityResponse: MediatorLiveData<Resource<List<Cashier>>> = MediatorLiveData()
    fun observeCashierResponse() = cashierEntityResponse as LiveData<Resource<List<Cashier>>>

    fun getCashierList() = viewModelScope.launch{
        val source = getLatestCashierUseCase().asLiveData()
        cashierEntityResponse.addSource(source){
            if (it != null) {
                cashierEntityResponse.value = it
                if (it.status !== Resource.Status.LOADING) {
                    cashierEntityResponse.removeSource(source)
                }
            } else {
                cashierEntityResponse.removeSource(source)
            }
        }
    }

    fun onItemClick(cashier: Cashier) = viewModelScope.launch {
        cashier.isActive = true
        updateActiveCashierUseCase(cashier)
        eventChannel.send(UIEvent.NavigateToPin)
    }

    sealed class UIEvent {
        object NavigateToPin : UIEvent()
    }
}