package com.bits.bee.bpmc.presentation.ui.pilih_kasir

import androidx.lifecycle.*
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.ActivateCashierUseCase
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
    private val updateActiveCashierUseCase: UpdateActiveCashierUseCase,
    private val activateCashierUseCase: ActivateCashierUseCase
) : BaseViewModel<PilihKasirState, PilihKasirViewModel.UIEvent>() {

    private var cashierEntityResponse: MediatorLiveData<Resource<List<Cashier>>> = MediatorLiveData()
    fun observeCashierResponse() = cashierEntityResponse as LiveData<Resource<List<Cashier>>>

    fun getCashierList() = viewModelScope.launch {
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

    fun onItemClick(cashier: Cashier, deviceName : String) = viewModelScope.launch {
        activateCashierUseCase(cashier, deviceName).collect{
            when(it.status){
                Resource.Status.LOADING -> {
                    showDialog()
                }
                Resource.Status.SUCCESS -> {
                    hideDialog()
                    cashier.isActive = true
                    updateActiveCashierUseCase(cashier)
                    eventChannel.send(UIEvent.NavigateToPin)
                }
                Resource.Status.ERROR -> {
                    hideDialog()
                }
            }
        }
    }

    private fun showDialog() = viewModelScope.launch {
        eventChannel.send(UIEvent.ShowDialog(true))
    }

    private fun hideDialog() = viewModelScope.launch {
        eventChannel.send(UIEvent.ShowDialog(false))
    }

    sealed class UIEvent {
        object NavigateToPin : UIEvent()
        data class ShowDialog(val isShowDialog: Boolean) : UIEvent()
    }
}