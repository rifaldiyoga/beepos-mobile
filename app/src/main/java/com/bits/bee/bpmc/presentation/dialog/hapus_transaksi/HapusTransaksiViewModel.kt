package com.bits.bee.bpmc.presentation.dialog.hapus_transaksi

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.helper.PrivilegeHelper
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.pembayaran.RefundGopayUseCase
import com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.VoidTransactionUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 03/11/22
 */
@HiltViewModel
class HapusTransaksiViewModel @Inject constructor(
    private val privilegeHelper: PrivilegeHelper,
    private val voidTransactionUseCase: VoidTransactionUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val refundGopayUseCase: RefundGopayUseCase
) : BaseViewModel<HapusTransaksiState, HapusTransaksiViewModel.UIEvent>(){

    init {
        state = HapusTransaksiState()
    }

    fun loadData() = viewModelScope.launch {
        state.isCanVoid = privilegeHelper.hasAccess(BPMConstants.BPM_PRIVILEGE_OBJ, BPMConstants.ACS_DEL)
    }

    fun onClickHapus() = viewModelScope.launch {
        doVoid()
    }

    fun doVoid() = viewModelScope.launch {
        var isValid = true
        val posses = getActivePossesUseCase().first()
        if(posses == null || state.sale!!.possesId != posses.possesId){
            isValid = false
            sendMessage("Tidak dapat menghapus transaksi ini dikarenakan sudah tutup kasir!")
        } else if(state.alasan.isEmpty()){
            isValid = false
            sendMessage("Alasan hapus wajib diisi!")
        } else if(state.alasan.length < 5){
            isValid = false
            sendMessage("Alasan harus terdiri dari minimal 5 karakter!")
        } else if(!state.isCanVoid) {
            isValid = false
            eventChannel.send(UIEvent.NavigateToHakAkses)
        }

        if(isValid) {

            state.sale?.let {
                it.voidNote = state.alasan
                if(it.termType == BPMConstants.BPM_DEFAULT_TYPE_CASH_GOPAY)
                    doRefunGopay()
                try {
                    voidTransactionUseCase(it)
                    eventChannel.send(UIEvent.SuccessVoid)
                } catch (e : Exception){

                }

            }
        }
    }

    suspend fun doRefunGopay(){
        refundGopayUseCase(state.sale!!).collect {
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    it.data?.let {
                        Log.i("Refund Gopay", it.data.status_message)
                    }
                }
                Resource.Status.ERROR -> {

                }
                Resource.Status.NOINTERNET -> {

                }
            }
        }
    }

    sealed class UIEvent {
        object NavigateToHakAkses : UIEvent()
        object SuccessVoid : UIEvent()
    }

}