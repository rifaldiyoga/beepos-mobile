package com.bits.bee.bpmc.presentation.ui.tutup_kasir

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.buka_kasir.BukaKasirUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 08/06/22.
 */
@HiltViewModel
class DetailTutupKasirViewModel @Inject constructor(
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val bukaKasirUseCase: BukaKasirUseCase
): BaseViewModel<DetailTutupKasirState, DetailTutupKasirViewModel.UIEvent>() {

    init {
        state = DetailTutupKasirState()
    }

    val getActiveCashier = getActiveCashierUseCase()

    val getActiveBranch = getActiveBranchUseCase()

    fun onBukaKasir() = viewModelScope.launch{
        if(state.modal == null){
            eventChannel.send(UIEvent.NavigateToDefaultModal)
        }else {
            saveBukaKasir()
        }
    }

    fun saveBukaKasir() = viewModelScope.launch{
        bukaKasirUseCase(state.modal!!, state.shift, state.branch!!, state.cashier!!)
        eventChannel.send(UIEvent.NavigateToPos)
    }

    sealed class UIEvent {
        object NavigateToDefaultModal : UIEvent()
        object NavigateToPos : UIEvent()
    }
}