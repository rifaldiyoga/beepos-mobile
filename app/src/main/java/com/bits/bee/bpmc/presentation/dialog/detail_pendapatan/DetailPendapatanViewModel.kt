package com.bits.bee.bpmc.presentation.dialog.detail_pendapatan

import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailPendapatanViewModel @Inject constructor(

): BaseViewModel<DetailPendapatanState, DetailPendapatanViewModel.UIEvent>() {

    init {
        state = DetailPendapatanState()
    }

    sealed class UIEvent {
        object RequestInfoTax : UIEvent()
    }
}