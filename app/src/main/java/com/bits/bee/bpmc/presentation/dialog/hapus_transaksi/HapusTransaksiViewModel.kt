package com.bits.bee.bpmc.presentation.dialog.hapus_transaksi

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.helper.PrivilegeHelper
import com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.VoidTransactionUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 03/11/22
 */
@HiltViewModel
class HapusTransaksiViewModel @Inject constructor(
    private val privilegeHelper: PrivilegeHelper,
    private val voidTransactionUseCase: VoidTransactionUseCase,
) : BaseViewModel<HapusTransaksiState, HapusTransaksiViewModel.UIEvent>(){

    fun loadData() = viewModelScope.launch {
        state.isCanVoid = privilegeHelper.hasAccess(BPMConstants.BPM_PRIVILEGE_OBJ, BPMConstants.ACS_DEL)
    }

    fun onClickHapus() = viewModelScope.launch {
        if(!state.isCanVoid){
            eventChannel.send(UIEvent.NavigateToHakAkses)
        } else {
            doVoid()
        }
    }

    fun doVoid() = viewModelScope.launch {
        state.sale?.let {
            it.voidNote = state.alasan
            voidTransactionUseCase(it)
            eventChannel.send(UIEvent.SuccessVoid)
        }
    }

    sealed class UIEvent {
        object NavigateToHakAkses : UIEvent()
        object SuccessVoid : UIEvent()
    }

}