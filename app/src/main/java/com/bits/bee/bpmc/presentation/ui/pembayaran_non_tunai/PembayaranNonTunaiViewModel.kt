package com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 02/06/22.
 */
@HiltViewModel
class PembayaranNonTunaiViewModel @Inject constructor(): BaseViewModel<PembayaranNonTunaiState, PembayaranNonTunaiViewModel.UIEvent>(){

    init {
        state = PembayaranNonTunaiState()
    }

    fun onClickGopay() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToGopay)
    }

    fun onClickDebitKredit() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToDebitKredit)
    }

    sealed class UIEvent {
        object NavigateToGopay : UIEvent()
        object NavigateToDebitKredit : UIEvent()
    }
}