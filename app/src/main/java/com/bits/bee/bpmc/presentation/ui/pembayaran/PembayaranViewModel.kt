package com.bits.bee.bpmc.presentation.ui.pembayaran

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 25/05/22.
 */
@HiltViewModel
class PembayaranViewModel @Inject constructor(
) : BaseViewModel<PembayaranState, PembayaranViewModel.UIEvent>() {

    init {
        state = PembayaranState()
    }

    fun onTunaiClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestBayar)
        eventChannel.send(UIEvent.NavigateTransaksiBerhasil)
    }

    fun onNonTunaiClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateNonTunai)
    }

    fun onRekomBayarClick(data : String) = viewModelScope.launch {
        updateState(
            state.copy(
                rekomBayar = data
            )
        )
        eventChannel.send(UIEvent.RequestRekomBayar)
    }


    sealed class UIEvent {
        object NavigateTransaksiBerhasil : UIEvent()
        object NavigateNonTunai : UIEvent()
        object RequestRekomBayar : UIEvent()
        object RequestBayar : UIEvent()
    }

}