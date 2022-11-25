package com.bits.bee.bpmc.presentation.ui.buka_kasir

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.buka_kasir.BukaKasirUseCase
import com.bits.bee.bpmc.domain.usecase.buka_kasir.GetCounterShiftUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetDefaultCrcUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetUserByIdUseCase
import com.bits.bee.bpmc.domain.usecase.tutup_kasir.TutupKasirUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
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
    private val getDefaultCrcUseCase: GetDefaultCrcUseCase,
    private val bukaKasirUseCase: BukaKasirUseCase,
    private val tutupKasirUseCase: TutupKasirUseCase,
    private val getCounterShiftUseCase: GetCounterShiftUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val beePreferenceManager: BeePreferenceManager
) : BaseViewModel<BukaTutupKasirState, BukaTutupKasirSharedViewModel.UIEvent>() {

    val posPreferences = beePreferenceManager.posPreferences

    init {
        state = BukaTutupKasirState()
        getActivePosses()
        getActiveBranch()
        getActiveCashier()
        getDefaultCrc()
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

    fun getDefaultCrc() = viewModelScope.launch {
        getDefaultCrcUseCase().collect {
            updateState(
                state.copy(
                    crc = it
                )
            )
        }
    }

    fun getUser() = viewModelScope.launch {
        getUserByIdUseCase.invoke(state.activePosses!!.userId).collect {
            updateState(
                state.copy(
                    user = it
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

            updateState(
                state.copy(
                    listCasha = it
                )
            )

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

    suspend fun doBukaKasir(modal : String, sesi: Int) = viewModelScope.launch {
        if (modal.isEmpty() || modal.contains(Regex("[A-Za-z]")))
            msgChannel.send("Modal yang anda masukkan salah!")
        else {
            val modalC = BigDecimal(modal)
            bukaKasirUseCase(modalC, sesi, state.activeBranch!!, state.activeCashier!!)
            getActivePosses()
            eventChannel.send(UIEvent.NavigateToPos)
        }
    }

    suspend fun doTutupKasir() {
        state.activePosses?.let {
            tutupKasirUseCase(
                posses = it
            )
        }
    }

    fun resetActivePosses() = viewModelScope.launch {
        updateState(
            state.copy(
                activePosses = null
            )
        )
    }

    sealed class UIEvent {
        object NavigateToPos : UIEvent()
    }
}