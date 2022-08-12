package com.bits.bee.bpmc.presentation.ui.analisis_sesi

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetNotActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetUserByIdUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.tutup_kasir.DetailTutupKasirViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnalisaSesiViewModel @Inject constructor(
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val getNotActivePossesUseCase: GetNotActivePossesUseCase
):BaseViewModel<AnalisaSesiState, AnalisaSesiViewModel.UIEvent>() {

    init {
        state = AnalisaSesiState()
        checkPosses()
//        getActivePosses()
//        getActiveBranch()
//        getCashierActive()
    }

    private fun checkPosses() = viewModelScope.launch {
        getNotActivePossesUseCase.invoke().collect {
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
            it.data?.let {
                updateState(
                    state.copy(
                        user = it
                    )
                )
            }
        }
    }

    fun onClickMenu() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestRiwayatSesi)
    }

    fun onClickBukaKasir() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequstDetailBukaKasir)
    }

//    fun getActiveBranch() = viewModelScope.launch {
//        getActiveBranchUseCase.invoke().collect {
//            updateState(
//                state.copy(
//                    activeBranch = it
//                )
//            )
//        }
//    }
//
//    fun getCashierActive() = viewModelScope.launch {
//        getActiveCashierUseCase.invoke().collect {
//            it?.let {
//                updateState(
//                    state.copy(
//                        activeCashier = it
//                    )
//                )
//            }
//        }
//    }

    sealed class UIEvent {
        object RequestRiwayatSesi : UIEvent()
        object RequstDetailBukaKasir : UIEvent()
    }
}