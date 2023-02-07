package com.bits.bee.bpmc.presentation.ui.pembayaran_gopay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.remote.response.GopayResponse
import com.bits.bee.bpmc.data.data_source.remote.response.GopayStatusResponse
import com.bits.bee.bpmc.domain.usecase.pembayaran.CancelPaymentGopayUseCase
import com.bits.bee.bpmc.domain.usecase.pembayaran.CheckPaymentGopayUseCase
import com.bits.bee.bpmc.domain.usecase.pembayaran.RequestQRGopayUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 02/06/22.
 */
@HiltViewModel
class PembayaranGopayViewModel @Inject constructor(
    private val requestQRGopayUseCase: RequestQRGopayUseCase,
    private val checkPaymentGopayUseCase: CheckPaymentGopayUseCase,
    private val cancelPaymentGopayUseCase: CancelPaymentGopayUseCase
) : BaseViewModel<PembayaranGopayState, PembayaranGopayViewModel.UIEvent>(){

    init {
        state = PembayaranGopayState()
    }

    private var requestGopayResponse: MediatorLiveData<Resource<GopayResponse>> = MediatorLiveData()
    fun observeGopayResponse() = requestGopayResponse as LiveData<Resource<GopayResponse>>

    fun requestQRCode() = viewModelScope.launch {
        if(state.sale != null || state.bp != null) {
            val source = requestQRGopayUseCase(state.sale!!, state.saledList, state.bp!!).asLiveData()
            requestGopayResponse.addSource(source) {
                if (it != null) {
                    requestGopayResponse.value = it
                    if (it.status !== Resource.Status.LOADING) {
                        requestGopayResponse.removeSource(source)
                    }
                } else {
                    requestGopayResponse.removeSource(source)
                }
            }
        }
    }

    private var checkStatusGopayResponse: MediatorLiveData<Resource<GopayStatusResponse>> = MediatorLiveData()
    fun observeGopayStatusResponse() = checkStatusGopayResponse as LiveData<Resource<GopayStatusResponse>>

    fun checkStatusPayment() {
        if(state.sale != null) {
            val source = checkPaymentGopayUseCase(state.sale!!.gopayTransactionId).asLiveData()
            checkStatusGopayResponse.addSource(source) {
                if (it != null) {
                    checkStatusGopayResponse.value = it
                    if (it.status !== Resource.Status.LOADING) {
                        checkStatusGopayResponse.removeSource(source)
                    }
                } else {
                    checkStatusGopayResponse.removeSource(source)
                }
            }
        }
    }

    private var cancelGopayResponse: MediatorLiveData<Resource<GopayStatusResponse>> = MediatorLiveData()
    fun observeCancelGopayResponse() = cancelGopayResponse as LiveData<Resource<GopayStatusResponse>>

    fun cancelPayment() {
        if(state.sale != null) {
            val source = cancelPaymentGopayUseCase(state.sale!!.gopayTransactionId).asLiveData()
            cancelGopayResponse.addSource(source) {
                if (it != null) {
                    cancelGopayResponse.value = it
                    if (it.status !== Resource.Status.LOADING) {
                        cancelGopayResponse.removeSource(source)
                    }
                } else {
                    cancelGopayResponse.removeSource(source)
                }
            }
        }
    }



    sealed class UIEvent {

    }
}