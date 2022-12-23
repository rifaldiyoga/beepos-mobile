package com.bits.bee.bpmc.presentation.ui.pos.invoice

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.pos.AddTransactionUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 25/04/22.
 */
@HiltViewModel
class InvoiceViewModel @Inject constructor(
    private val addTransactionUseCase: AddTransactionUseCase
) : BaseViewModel<Any, InvoiceViewModel.UIEvent>(){

    init {
        state = Any()
    }

    fun onClickBayar() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestPembayaran)
    }

    fun onClickBatal() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestBatal)
    }

    fun onClickDraft() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDraft)
    }

    fun onClickPromo() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateKlaimPromo)
    }

    fun onDetailEmpty() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigatePos)
        msgChannel.send("Tidak ada data detail!")
    }

    sealed class UIEvent {
        object NavigatePos : UIEvent()
        object NavigateKlaimPromo : UIEvent()
        object RequestPembayaran : UIEvent()
        object RequestBatal : UIEvent()
        object RequestDraft : UIEvent()
    }

}