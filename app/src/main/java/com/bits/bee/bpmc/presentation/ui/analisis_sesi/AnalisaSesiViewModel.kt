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
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

@HiltViewModel
class AnalisaSesiViewModel @Inject constructor(
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase,
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
//        getActivePosses()
    }

    val reg = getRegPossesActualEndCashUseCase(BPMConstants.REG_POSSES_ACTUAL_ENDCASH)


    fun getActivePosses() = viewModelScope.launch {
        getActivePossesUseCase.invoke().collect {
            updateState(
                state.copy(
                    posses = it
                )
            )
        }
    }

    suspend fun getValueDetail() {
        state.posses?.let { data ->
            updateState(
                state.copy(
                    user = getUserByIdUseCase.invoke(data.userId).first(),
                    saleList =  getSaleByPossesUseCase.invoke(data.possesId!!).first().filter { !it.isVoid },
                    bpDateList = getBpByDateUseCase.invoke(DateFormatUtils.convertStartDate(data.trxDate.time,), DateFormatUtils.convertEndDate(data.trxDate.time)).first(),
                    notaSucces = getCountNotaUseCase.invoke(data.possesId!!).first(),
                    notaVoid = getCountNotaVoidUseCase.invoke(data.possesId!!).first(),
                    totalTunai = getTotalPaidTunaiUseCase.invoke(data.possesId!!, data.trxNo),
                    totalDebit = getTotalPaidDebitUseCase.invoke(data.possesId!!).first(),
                    totalKredit = getTotalPaidKreditUseCase.invoke(data.possesId!!).first(),
                    totalGopay = getTotalPaidGopayUseCase.invoke(data.possesId!!).first(),
                    rankItem = getRankItemUseCase.invoke(data.possesId!!).first(),
                    listEntry = getSumByHourUseCase.invoke(data) ?: mutableListOf()
                )
            )
        }
    }

    fun getTotalNonTunai(): BigDecimal{
        var nonTunai = state.totalDebit.add(state.totalKredit).add(state.totalGopay)
        return nonTunai
    }

    fun totalAvg(saleList: List<Sale>): BigDecimal{
        var total = BigDecimal.ZERO
        for (sale in saleList) {
            if (!sale.isVoid) total = total.add(sale.total)
        }
        return if (saleList.isNotEmpty()) total.divide(
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

    fun onClickInfo() = viewModelScope.launch{
        eventChannel.send(UIEvent.RequestInfoSetoran)
    }

    sealed class UIEvent {
        object RequestRiwayatSesi : UIEvent()
        object RequstDetailBukaKasir : UIEvent()
        object RequestInfoSetoran : UIEvent()
    }
}