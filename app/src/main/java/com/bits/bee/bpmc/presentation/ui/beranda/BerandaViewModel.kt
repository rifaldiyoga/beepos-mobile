package com.bits.bee.bpmc.presentation.ui.beranda

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 03/06/22.
 */
@HiltViewModel
class BerandaViewModel @Inject constructor(
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase
) : BaseViewModel<BerandaState, BerandaViewModel.UIEvent>() {

    init {
        state = BerandaState()
        getActivePosses()
    }

    val getActiveCashier = getActiveCashierUseCase()
    val getActiveBranch = getActiveBranchUseCase()

    fun getActivePosses() = viewModelScope.launch {
        getActivePossesUseCase().collect {
            updateState(state.copy(posses = it))
        }
    }

    fun onDetailBukaKasirClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToBukaKasir)
    }

    fun onBukaKasirClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToDialogBukaKasir)
    }

    sealed class UIEvent {
        object NavigateToBukaKasir : UIEvent()
        object NavigateToDialogBukaKasir : UIEvent()
        object NavigateToTutupKasir : UIEvent()
    }
}