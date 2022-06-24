package com.bits.bee.bpmc.presentation.ui.transaksi_penjualan

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetLatestSaleUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 23/06/22.
 */
@HiltViewModel
class TransaksiPenjualanViewModel @Inject constructor(
    private val getLatestSaleUseCase: GetLatestSaleUseCase
) : BaseViewModel<TransaksiPenjualanState, TransaksiPenjualanViewModel.UIEvent>() {

    init {
        state = TransaksiPenjualanState()
    }

    fun getLatestSale() = viewModelScope.launch {
        getLatestSaleUseCase().collect {
            updateState(
                state.copy(
                    it
                )
            )
        }
    }

    sealed class UIEvent{

    }

}