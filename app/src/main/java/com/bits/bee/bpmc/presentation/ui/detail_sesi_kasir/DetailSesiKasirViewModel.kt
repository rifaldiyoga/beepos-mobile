package com.bits.bee.bpmc.presentation.ui.detail_sesi_kasir

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetPossesByIdUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetUserByIdUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailSesiKasirViewModel @Inject constructor(
    private val getPossesByIdUseCase: GetPossesByIdUseCase,
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase
): BaseViewModel<DetailSesiKasirState, DetailSesiKasirViewModel.UIEvent>() {

    init {
        state = DetailSesiKasirState()
        getActiveBranch()
        getCashierActive()
    }

    fun onClickDetail(model: Posses) = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDetailPendapatan(model))
    }

    fun getActiveBranch() = viewModelScope.launch {
        getActiveBranchUseCase.invoke().collect {
            updateState(
                state.copy(
                    activeBranch = it
                )
            )
        }
    }

    fun getCashierActive() = viewModelScope.launch {
        getActiveCashierUseCase.invoke().collect {
            it?.let {
                updateState(
                    state.copy(
                        activeCashier = it
                    )
                )
            }
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

    sealed class UIEvent {
        data class RequestDetailPendapatan(val model: Posses) : UIEvent()
    }
}