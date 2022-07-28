package com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Pmtd
import com.bits.bee.bpmc.domain.usecase.pembayaran.GetActivePmtd
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 02/06/22.
 */
@HiltViewModel
class PembayaranNonTunaiViewModel @Inject constructor(
    private val getActivePmtd: GetActivePmtd
): BaseViewModel<PembayaranNonTunaiState, PembayaranNonTunaiViewModel.UIEvent>(){

    init {
        state = PembayaranNonTunaiState()
    }

    fun loadPmtd() = viewModelScope.launch {
        getActivePmtd().collect {
            updateState(
                state.copy(
                    pmtdList = it
                )
            )
        }
    }



    fun onClickItem(pmtd: Pmtd) = viewModelScope.launch {
        if(pmtd.ccType != BPMConstants.BPM_DEFAULT_TYPE_CASH_GOPAY) {
            eventChannel.send(UIEvent.NavigateToDebitKredit(pmtd))
        } else {
            eventChannel.send(UIEvent.NavigateToGopay)
        }
    }

    sealed class UIEvent {
        object NavigateToGopay : UIEvent()
        data class NavigateToDebitKredit(var pmtd : Pmtd) : UIEvent()
    }
}