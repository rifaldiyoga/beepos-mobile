package com.bits.bee.bpmc.presentation.ui.pembayaran_kartu

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.trans.SaleTrans
import com.bits.bee.bpmc.domain.usecase.common.GetRegUseCase
import com.bits.bee.bpmc.domain.usecase.pembayaran.GetActiveEdc
import com.bits.bee.bpmc.domain.usecase.pembayaran.GetActiveEdcSurc
import com.bits.bee.bpmc.domain.usecase.pos.AddTransactionUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 02/06/22.
 */
@HiltViewModel
class PembayaranKartuViewModel @Inject constructor(
    private val getRegUseCase: GetRegUseCase
) : BaseViewModel<PembayaranKartuState, PembayaranKartuViewModel.UIEvent>(){

    init {
        state = PembayaranKartuState()
    }

    val regCardNoReq = getRegUseCase(BPMConstants.REG_POS_CARDNO_REQUIRED)
    val regTrackNoReq = getRegUseCase(BPMConstants.REG_POS_TRACKNO_REQUIRED)

    fun onBayarClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequsetBayar)
    }

    fun onSuccessBayar() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToTransaksiBerhasil)
    }


    sealed class UIEvent {
        object RequsetBayar : UIEvent()
        object NavigateToTransaksiBerhasil : UIEvent()
    }
}