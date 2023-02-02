package com.bits.bee.bpmc.presentation.dialog.detail_pendapatan

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidDebitUseCase
import com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidGopayUseCase
import com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidKreditUseCase
import com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidTunaiUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetRegUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class DetailPendapatanViewModel @Inject constructor(
    private val getTotalPaidTunaiUseCase: GetTotalPaidTunaiUseCase,
    private val getTotalPaidDebitUseCase: GetTotalPaidDebitUseCase,
    private val getTotalPaidKreditUseCase: GetTotalPaidKreditUseCase,
    private val getTotalPaidGopayUseCase: GetTotalPaidGopayUseCase,
    private val getRegUseCase: GetRegUseCase
): BaseViewModel<DetailPendapatanState, DetailPendapatanViewModel.UIEvent>() {

    init {
        state = DetailPendapatanState()
    }

    val possesActualCashReg = getRegUseCase(BPMConstants.REG_POSSES_ACTUAL_ENDCASH)

    fun getValueDetail() = viewModelScope.launch {
        updateState(
            state.copy(
                totalTunai = getTotalPaidTunaiUseCase.invoke(state.posses!!.possesId!!, state.posses!!.trxNo),
                totalDebit = getTotalPaidDebitUseCase.invoke(state.posses!!.possesId!!).first(),
                totalKredit =  getTotalPaidKreditUseCase.invoke(state.posses!!.possesId!!).first(),
                totalGopay = getTotalPaidGopayUseCase.invoke(state.posses!!.possesId!!).first()
            )
        )
    }

    fun getTotalNonTunai(): BigDecimal {
        val nonTunai = state.totalDebit!!.add(state.totalKredit).add(state.totalGopay)
        return nonTunai
    }

    sealed class UIEvent {
        object RequestInfoTax : UIEvent()
    }
}