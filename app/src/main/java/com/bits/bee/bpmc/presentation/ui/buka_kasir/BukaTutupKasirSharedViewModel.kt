package com.bits.bee.bpmc.presentation.ui.buka_kasir

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.domain.usecase.buka_kasir.BukaKasirUseCase
import com.bits.bee.bpmc.domain.usecase.buka_kasir.GetCounterShiftUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetUserByIdUseCase
import com.bits.bee.bpmc.domain.usecase.tutup_kasir.TutupKasirUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.DateFormatUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 20/06/22.
 */
@HiltViewModel
class BukaTutupKasirSharedViewModel @Inject constructor(
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val bukaKasirUseCase: BukaKasirUseCase,
    private val tutupKasirUseCase: TutupKasirUseCase,
    private val getCounterShiftUseCase: GetCounterShiftUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase
) : BaseViewModel<BukaTutupKasirState, BukaTutupKasirSharedViewModel.UIEvent>() {

    init {
        state = BukaTutupKasirState()
        getActivePosses()
        getActiveBranch()
        getActiveCashier()
        setShift()
    }

    fun getActivePosses() = viewModelScope.launch {
        getActivePossesUseCase().collect {
            updateState(
                state.copy(
                    activePosses = it
                )
            )
        }
    }

    fun getUser() = viewModelScope.launch {
        getUserByIdUseCase.invoke(state.activePosses!!.userId).collect {
            updateState(
                state.copy(
                    user = it.data
                )
            )
        }
    }

    fun getActiveBranch() = viewModelScope.launch {
        getActiveBranchUseCase().collect {
            updateState(
                state.copy(
                    activeBranch = it
                )
            )
        }
    }

    fun getActiveCashier() = viewModelScope.launch {
        getActiveCashierUseCase().collect {
            updateState(
                state.copy(
                    activeCashier = it
                )
            )
        }
    }

    fun setShift() = viewModelScope.launch {
        getCounterShiftUseCase.invoke().collect {
            it.data?.let {
                updateState(
                    state.copy(
                        listCasha = it
                    )
                )
            }
        }

//        if (state.listCasha!!.size > 0){
//            val trxDate = DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT, state.listCasha!!.get(0).trxDate)
//            if (SimpleDateFormat("MMdd").format(Date())compareTo(SimpleDateFormat("MMdd").format(trxDate)) > 0){
//                updateState(
//                    state.copy(
//                        shift = 1
//                    )
//                )
//            }else{
//
//            }
//        }else{
//            updateState(
//                state.copy(
//                    shift = 1
//                )
//            )
//        }
    }

    fun doBukaKasir(modal : BigDecimal, sesi: Int) = viewModelScope.launch {
        bukaKasirUseCase.invoke(modal, sesi, state.activeBranch!!, state.activeCashier!!)
//        bukaKasirUseCase(
//            modal = modal,
//            shift = 1,
//            cashier = state.activeCashier!!,
//            branch = state.activeBranch!!
//        )
        getActivePosses()
    }

    fun doTutupKasir() = viewModelScope.launch {
        state.activePosses?.let {
            tutupKasirUseCase(
                posses = it
            )
            updateState(
                state.copy(
                    null
                )
            )
        }
    }

    sealed class UIEvent {

    }
}