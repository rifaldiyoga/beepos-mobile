package com.bits.bee.bpmc.presentation.ui.pembayaran_kartu

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.usecase.pembayaran.GetActiveEdc
import com.bits.bee.bpmc.domain.usecase.pembayaran.GetActiveEdcSurc
import com.bits.bee.bpmc.domain.usecase.pos.AddTransactionUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 02/06/22.
 */
@HiltViewModel
class PembayaranKartuViewModel @Inject constructor(
    private val getActiveEdc: GetActiveEdc,
    private val getActiveEdcSurc: GetActiveEdcSurc,
    private val addTransactionUseCase: AddTransactionUseCase
) : BaseViewModel<PembayaranKartuState, PembayaranKartuViewModel.UIEvent>(){

    init {
        state = PembayaranKartuState()
    }


    fun onBayarClick(sale : Sale, saledList : List<Saled>) = viewModelScope.launch {
        sale.termType = state.type
        addTransactionUseCase(sale, saledList, sale.total, state.pmtd, state.trackNo, state.nomorkartu, state.keterangan)
        eventChannel.send(UIEvent.NavigateToTransaksiBerhasil)
    }

    sealed class UIEvent {
        object NavigateToTransaksiBerhasil : UIEvent()
    }
}