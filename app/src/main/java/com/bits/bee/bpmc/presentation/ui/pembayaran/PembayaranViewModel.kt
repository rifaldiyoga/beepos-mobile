package com.bits.bee.bpmc.presentation.ui.pembayaran

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BSmartPay
import kotlinx.coroutines.launch
import java.math.BigDecimal

/**
 * Created by aldi on 25/05/22.
 */
class PembayaranViewModel : BaseViewModel<PembayaranState, PembayaranViewModel.UIEvent>() {

    init {
        state = PembayaranState(
            BigDecimal(11234),
            BSmartPay.genSmartPay(BigDecimal(11234))
        )

    }

    fun onTunaiClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateTransaksiBerhasil)
    }

    fun onNonTunaiClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateNonTunai)
    }

    sealed class UIEvent {
        object NavigateTransaksiBerhasil : UIEvent()
        object NavigateNonTunai : UIEvent()
    }

}