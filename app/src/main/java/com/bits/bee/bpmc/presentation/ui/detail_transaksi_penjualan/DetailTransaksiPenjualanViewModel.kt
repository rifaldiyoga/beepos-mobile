package com.bits.bee.bpmc.presentation.ui.detail_transaksi_penjualan

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.common.GetSaledBySaleUseCase
import com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.VoidTransactionUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 23/06/22.
 */
@HiltViewModel
class DetailTransaksiPenjualanViewModel @Inject constructor(
    private val getSaledBySaleUseCase: GetSaledBySaleUseCase,
    private val voidTransactionUseCase: VoidTransactionUseCase
): BaseViewModel<DetailTransaksiPenjualanState, DetailTransaksiPenjualanViewModel.UIEvent>(){

    init {
        state = DetailTransaksiPenjualanState()
    }

    fun onClickVoid() = viewModelScope.launch {
        state.sale!!.isVoid = true
        voidTransactionUseCase(state.sale!!)
    }

    fun getSaledList() = viewModelScope.launch {
        state.sale?.let {
            getSaledBySaleUseCase(it.id!!).collect {
                updateState(
                    state.copy(
                        saledList = it
                    )
                )
            }
        }
    }

    sealed class UIEvent {

    }

}