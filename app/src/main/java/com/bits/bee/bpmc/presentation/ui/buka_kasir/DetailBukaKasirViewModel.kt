package com.bits.bee.bpmc.presentation.ui.buka_kasir

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.buka_kasir.BukaKasirUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 08/06/22.
 */
@HiltViewModel
class DetailBukaKasirViewModel @Inject constructor(
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val bukaKasirUseCase: BukaKasirUseCase
): BaseViewModel<DetailBukaKasirState, DetailBukaKasirViewModel.UIEvent>() {

    init {
        state = DetailBukaKasirState()
    }

    val getActiveCashier = getActiveCashierUseCase()

    val getActiveBranch = getActiveBranchUseCase()

    fun onBukaKasir() = viewModelScope.launch{
        bukaKasirUseCase(state.modal, state.shift)
    }

    sealed class UIEvent {

    }
}