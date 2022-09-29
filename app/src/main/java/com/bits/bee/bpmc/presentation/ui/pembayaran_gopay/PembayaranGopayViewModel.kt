package com.bits.bee.bpmc.presentation.ui.pembayaran_gopay

import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by aldi on 02/06/22.
 */
@HiltViewModel
class PembayaranGopayViewModel @Inject constructor() : BaseViewModel<PembayaranGopayState, PembayaranGopayViewModel.UIEvent>(){

    init {
        state = PembayaranGopayState()
    }

    sealed class UIEvent {

    }
}