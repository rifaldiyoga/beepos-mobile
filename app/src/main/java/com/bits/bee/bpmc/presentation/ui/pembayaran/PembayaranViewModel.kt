package com.bits.bee.bpmc.presentation.ui.pembayaran

import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BSmartPay
import dagger.hilt.android.lifecycle.HiltViewModel
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

    sealed class UIEvent {

    }

}