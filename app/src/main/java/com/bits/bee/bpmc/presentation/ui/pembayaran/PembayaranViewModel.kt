package com.bits.bee.bpmc.presentation.ui.pembayaran

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.pos.AddTransactionUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 25/05/22.
 */
@HiltViewModel
class PembayaranViewModel @Inject constructor() : BaseViewModel<PembayaranState, PembayaranViewModel.UIEvent>() {

    init {
        state = PembayaranState()
    }

    fun onTunaiClick() = viewModelScope.launch {
        var isValid = true
        if(state.rekomBayar.isEmpty()) {
            isValid = false
            errorChannel.send("Maasukkan nominal pembayaran!")
        } else if(state.total > BigDecimal(state.rekomBayar)) {
            isValid = false
            errorChannel.send("Nominal pembayaran kurang dari total bayar!")
        }

        if(isValid)
            eventChannel.send(UIEvent.RequestBayar)
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

    fun onSuccess() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateTransaksiBerhasil)
    }


    sealed class UIEvent {
        object NavigateTransaksiBerhasil : UIEvent()
        object NavigateNonTunai : UIEvent()
        object RequestRekomBayar : UIEvent()
        object RequestBayar : UIEvent()
    }

}