package com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.printer.helper.PrinterHelper
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetUserByIdUseCase
import com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetCashierByIdUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailRiwayatSesiViewModel @Inject constructor(
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val getCashierByIdUseCase: GetCashierByIdUseCase,
    private val printerHelper: PrinterHelper
): BaseViewModel<DetailRiwayatSesiState, DetailRiwayatSesiViewModel.UIEvent>() {

    init {
        state = DetailRiwayatSesiState()
        getActiveBranch()
    }

    private fun getActiveBranch() = viewModelScope.launch {
        getActiveBranchUseCase.invoke().collect {
            updateState(
                state.copy(
                    activeBranch = it
                )
            )
        }
    }

    fun detailValue() = viewModelScope.launch {
        getUserByIdUseCase.invoke(state.posses!!.userId).collect {
            updateState(
                state.copy(
                    user = it
                )
            )
        }
        getCashierByIdUseCase.invoke(state.posses!!.cashierId).collect {
            it?.let {
                updateState(
                    state.copy(
                        cashier = it
                    )
                )
            }
        }
    }

    fun onClickDetail() = viewModelScope.launch {
        state.posses?.let {
            eventChannel.send(UIEvent.RequestDetailPendapatan(it))
        }
    }

    fun onClickPrint() = viewModelScope.launch {
        state.posses?.let {
            printerHelper.printClosingCashier(it)
        }
    }

    fun detailAnalisaSesi() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestAnalisaSesi)
    }

    sealed class UIEvent {
        data class RequestDetailPendapatan(val model: Posses) : UIEvent()
        object RequestAnalisaSesi : UIEvent()
    }
}