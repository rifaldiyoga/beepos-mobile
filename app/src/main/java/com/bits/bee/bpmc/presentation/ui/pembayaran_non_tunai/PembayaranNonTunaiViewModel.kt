package com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai

import androidx.lifecycle.ViewModel
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by aldi on 02/06/22.
 */
@HiltViewModel
class PembayaranNonTunaiViewModel @Inject constructor(): ViewModel(){


    sealed class UIEvent {

    }
}