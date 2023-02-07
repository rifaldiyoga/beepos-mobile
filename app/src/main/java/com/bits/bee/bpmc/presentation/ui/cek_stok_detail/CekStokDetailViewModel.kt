package com.bits.bee.bpmc.presentation.ui.cek_stok_detail

import com.bits.bee.bpmc.domain.repository.StockRepository
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CekStokDetailViewModel @Inject constructor(
    val stockRepository : StockRepository
) : BaseViewModel<CekStokDetailState, CekStokDetailViewModel.UIEvent>() {

    init {
        state = CekStokDetailState()
    }

    sealed class UIEvent {

    }

}