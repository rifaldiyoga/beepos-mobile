package com.bits.bee.bpmc.presentation.ui.analisis_sesi

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.usecase.analisa_sesi.*
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetRegUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetSaledBySaleUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetUserByIdUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

@HiltViewModel
class AnalisaSesiViewModel @Inject constructor(
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val getActivePossesListUseCase: GetActivePossesListUseCase,
    private val getSaleByPossesUseCase: GetSaleByPossesUseCase,
    private val getBpByDateUseCase: GetBpByDateUseCase,
    private val getSaledBySaleUseCase: GetSaledBySaleUseCase,
    private val getCountNotaUseCase: GetCountNotaUseCase,
    private val getCountNotaVoidUseCase: GetCountNotaVoidUseCase,
    private val getTotalPaidTunaiUseCase: GetTotalPaidTunaiUseCase,
    private val getTotalPaidDebitUseCase: GetTotalPaidDebitUseCase,
    private val getTotalPaidKreditUseCase: GetTotalPaidKreditUseCase,
    private val getTotalPaidGopayUseCase: GetTotalPaidGopayUseCase,
    private val getRankItemUseCase: GetRankItemUseCase,
    private val getSumByHourUseCase: GetSumByHourUseCase,
    private val getRegPossesActualEndCashUseCase: GetRegUseCase
):BaseViewModel<AnalisaSesiState, AnalisaSesiViewModel.UIEvent>() {

    init {
        state = AnalisaSesiState()
        checkPosses()
//        getActivePosses()
//        getActiveBranch()
//        getCashierActive()
    }

    private fun checkPosses() = viewModelScope.launch {
        getActivePossesListUseCase.invoke().collect {
            it.data?.let {
                updateState(
                    state.copy(
                        possesList = it
                    )
                )
            }
        }
    }

    fun getActivePosses() = viewModelScope.launch {
        getActivePossesUseCase.invoke().collect {
            updateState(
                state.copy(
                    posses = it
                )
            )
        }
    }

    fun getValueDetail() = viewModelScope.launch {
        getUserByIdUseCase.invoke(state.posses!!.userId).collect {
            updateState(
                state.copy(
                    user = it
                )
            )
        }

        getSaleByPossesUseCase.invoke(state.posses!!.possesId!!).collect {
            it.data?.let {
                updateState(
                    state.copy(
                        saleList = it
                    )
                )
            }
        }

        getBpByDateUseCase.invoke(DateFormatUtils.convertStartDate(
            state.posses!!.trxDate.time,
        ), DateFormatUtils.convertEndDate(state.posses!!.trxDate.time)).collect {
            it.data?.let {
                updateState(
                    state.copy(
                        bpDateList = it
                    )
                )
            }
        }

        getCountNotaUseCase.invoke(state.posses!!.possesId!!).collect {
            updateState(
                state.copy(
                    notaSucces = it
                )
            )
        }

        getCountNotaVoidUseCase.invoke(state.posses!!.possesId!!).collect {
            updateState(
                state.copy(
                    notaVoid = it
                )
            )
        }

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

        getRankItemUseCase.invoke(state.posses!!.possesId!!).collect {
            updateState(
                state.copy(
                    rankItem = it
                )
            )
        }

        getRegPossesActualEndCashUseCase.invoke(BPMConstants.REG_POSSES_ACTUAL_ENDCASH).collect{
            updateState(
                state.copy(
                    reg = it
                )
            )
        }

        val chart = getSumByHourUseCase.invoke(state.posses!!)
        updateState(
            state.copy(
                listEntry = chart
            )
        )

    }

//    fun loadDataChart() = viewModelScope.launch {
//
//    }

    fun getTotalNonTunai(): BigDecimal{
        var nonTunai = state.totalDebit!!.add(state.totalKredit).add(state.totalGopay)
        return nonTunai
    }

    fun totalAvg(saleList: List<Sale>): BigDecimal{
        var total = BigDecimal.ZERO
        for (sale in saleList) {
            if (!sale.isVoid) total = total.add(sale.total)
        }
        return if (saleList.size != 0) total.divide(
            BigDecimal(saleList.size),
            2,
            RoundingMode.HALF_UP
        ) else BigDecimal.ZERO
    }

    suspend fun totalQty(saleList: List<Sale>): BigDecimal{
        var total = BigDecimal.ZERO
        for (sale in saleList) {
            if (!sale.isVoid)
                getSaledBySaleUseCase.invoke(sale.id!!).collect {
                    updateState(
                        state.copy(
                            saledList = it
                        )
                    )
                }
            state.saledList?.let {
                for (saled in state.saledList!!) {
//                    if (!ItemDao.getInstance().checkItemAddon(saled.getItem()))
                    total = total.add(saled.qty)
                }
            }

        }
        return total
    }

    fun onClickMenu() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestRiwayatSesi)
    }

    fun onClickBukaKasir() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequstDetailBukaKasir)
    }

    sealed class UIEvent {
        object RequestRiwayatSesi : UIEvent()
        object RequstDetailBukaKasir : UIEvent()
    }
}