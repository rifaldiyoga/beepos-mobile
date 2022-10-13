package com.bits.bee.bpmc.presentation.dialog.detail_pendapatan

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidDebitUseCase
import com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidGopayUseCase
import com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidKreditUseCase
import com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidTunaiUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class DetailPendapatanViewModel @Inject constructor(
    private val getTotalPaidTunaiUseCase: GetTotalPaidTunaiUseCase,
    private val getTotalPaidDebitUseCase: GetTotalPaidDebitUseCase,
    private val getTotalPaidKreditUseCase: GetTotalPaidKreditUseCase,
    private val getTotalPaidGopayUseCase: GetTotalPaidGopayUseCase
): BaseViewModel<DetailPendapatanState, DetailPendapatanViewModel.UIEvent>() {

    init {
        state = DetailPendapatanState()
    }

    fun getValueDetail() = viewModelScope.launch {
        getTotalPaidTunaiUseCase.invoke(state.posses!!.possesId!!).collect {
            updateState(
                state.copy(
                    totalTunai = it
                )
            )
        }

        getTotalPaidDebitUseCase.invoke(state.posses!!.possesId!!).collect {
            updateState(
                state.copy(
                    totalDebit = it
                )
            )
        }

        getTotalPaidKreditUseCase.invoke(state.posses!!.possesId!!).collect {
            updateState(
                state.copy(
                    totalKredit = it
                )
            )
        }

        getTotalPaidGopayUseCase.invoke(state.posses!!.possesId!!).collect {
            updateState(
                state.copy(
                    totalGopay = it
                )
            )
        }
    }

    fun getTotalNonTunai(): BigDecimal {
        var nonTunai = state.totalDebit!!.add(state.totalKredit).add(state.totalGopay)
        return nonTunai
    }

    sealed class UIEvent {
        object RequestInfoTax : UIEvent()
    }
}