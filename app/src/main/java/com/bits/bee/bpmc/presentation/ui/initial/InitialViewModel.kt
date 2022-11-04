package com.bits.bee.bpmc.presentation.ui.initial

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.response.CashierStatusResponse
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.login.operator.GetSaleNotUploadedUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.DetachCashierUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.UpdateActiveCashierUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 10/03/22.
 */
@HiltViewModel
class InitialViewModel @Inject constructor(
    private val getSaleNotUploadedUseCase: GetSaleNotUploadedUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val detachCashierUseCase: DetachCashierUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val updateActiveCashierUseCase: UpdateActiveCashierUseCase,
) : BaseViewModel<InitialState, InitialViewModel.UIEvent>() {

    init {
        state = InitialState()
    }

    private var cashierStatusResponse: MediatorLiveData<Resource<CashierStatusResponse>> = MediatorLiveData()
    fun observeCashierStatusResponse() = cashierStatusResponse as LiveData<Resource<CashierStatusResponse>>

    fun onBackOperator() = viewModelScope.launch{
        val mPosses = getActivePossesUseCase.invoke().first()
        val listSale = getSaleNotUploadedUseCase.invoke().first()

        if (mPosses != null){
            dialogHaventSync("Anda Tidak dapat pindah kasir pastikan sudah melakukan tutup kasir dan seluruh data telah ter-sync !")
        } else {
            if(listSale.isNotEmpty()){
                dialogHaventSync("Anda Tidak dapat pindah kasir pastikan seluruh data transkasi telah ter-sync !")
            } else {
                confirmGantiKasir()
            }
        }
    }

    fun deActiveStatusKasir(context : Context) = viewModelScope.launch {
        val deviceName = BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.pref_nama_device), "") as String
        val cashier = getActiveCashierUseCase().first()
        cashier?.let {
            val source = detachCashierUseCase.invoke(it, deviceName).asLiveData()
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
    }

    fun updateCashier() = viewModelScope.launch {
        val cashier = getActiveCashierUseCase().first()
        cashier?.let {
            updateActiveCashierUseCase.invoke(cashier)
        }
    }


    fun confirmGantiKasir() = viewModelScope.launch{
        eventChannel.send(UIEvent.RequestConfirmKasir)
    }

    fun dialogHaventSync(msg : String) = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDialogWarning(msg))
    }

    sealed class UIEvent {
        object RequestConfirmKasir : UIEvent()
        data class RequestDialogWarning(val msg : String) : UIEvent()
    }

}