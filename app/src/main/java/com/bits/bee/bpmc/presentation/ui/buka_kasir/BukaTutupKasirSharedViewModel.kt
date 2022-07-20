package com.bits.bee.bpmc.presentation.ui.buka_kasir

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.buka_kasir.BukaKasirUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.tutup_kasir.TutupKasirUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.math.BigDecimal
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
    private val tutupKasirUseCase: TutupKasirUseCase
) : BaseViewModel<BukaTutupKasirState, BukaTutupKasirSharedViewModel.UIEvent>() {

    init {
        state = BukaTutupKasirState()
        getActivePosses()
        getActiveBranch()
        getActiveCashier()
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

    fun doBukaKasir(modal : BigDecimal) = viewModelScope.launch {
        bukaKasirUseCase.invoke(modal, 1, state.activeBranch!!, state.activeCashier!!)
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