package com.bits.bee.bpmc.presentation.ui.pilih_cabang

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.usecase.pilih_cabang.GetLatestBranchUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_cabang.UpdateActiveBranchUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 17/03/22.
 */

@HiltViewModel
class PilihCabangViewModel @Inject constructor (
    private val getLatestBranchUseCase: GetLatestBranchUseCase,
    private val updateActiveBranchUseCase: UpdateActiveBranchUseCase
): BaseViewModel<PilihCabangState, PilihCabangViewModel.UIEvent>() {

    val getLatestBranch = getLatestBranchUseCase()

    fun onItemClick(branch: Branch) = viewModelScope.launch {
        updateActiveBranchUseCase(branch)
        eventChannel.send(UIEvent.NavigateToCashier)
    }

    sealed class UIEvent {
        object NavigateToCashier : UIEvent()
    }
}