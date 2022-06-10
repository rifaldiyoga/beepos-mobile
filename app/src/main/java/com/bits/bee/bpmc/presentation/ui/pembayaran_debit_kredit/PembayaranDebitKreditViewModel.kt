package com.bits.bee.bpmc.presentation.ui.pembayaran_debit_kredit

import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by aldi on 02/06/22.
 */
@HiltViewModel
class PembayaranDebitKreditViewModel @Inject constructor() : BaseViewModel<PembayaranDebitKreditState, PembayaranDebitKreditViewModel.UIEvent>(){


    sealed class UIEvent {

    }
}