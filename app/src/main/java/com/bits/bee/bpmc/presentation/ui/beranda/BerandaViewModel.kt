package com.bits.bee.bpmc.presentation.ui.beranda

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.remote.response.CheckLicResponse
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.usecase.common.*
import com.bits.bee.bpmc.domain.usecase.tutup_kasir.TutupKasirUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 03/06/22.
 */
@HiltViewModel
class BerandaViewModel @Inject constructor(
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val getRegUseCase: GetRegUseCase
) : BaseViewModel<BerandaState, BerandaViewModel.UIEvent>() {

    init {
        state = BerandaState()
    }

    val getActiveBranch = getActiveBranchUseCase()

    val possesActualCashReg = getRegUseCase(BPMConstants.REG_POSSES_ACTUAL_ENDCASH)

    fun onDetailBukaKasirClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToBukaKasir)
    }

    fun onDetailTutupKasirClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToTutupKasir)
    }

    fun onBukaKasirClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToDialogBukaKasir)
    }

    fun onTutupKasirClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToDialogTutupKasir)
    }

    fun onReqTutupKasir() = viewModelScope.launch {
        val reg = possesActualCashReg.first()
        reg?.let {
            if(it.value == "1"){
                eventChannel.send(UIEvent.NavigateToDialogSetoranKasir)
            } else {
                doTutupKasir()
            }
        }
    }

    fun doTutupKasir() = viewModelScope.launch {
        eventChannel.send(UIEvent.ReqTutupKasir)
    }

    sealed class UIEvent {
        object NavigateToBukaKasir : UIEvent()
        object NavigateToTutupKasir : UIEvent()
        object NavigateToDialogTutupKasir : UIEvent()
        object NavigateToDialogSetoranKasir: UIEvent()
        object NavigateToDialogBukaKasir : UIEvent()
        object ReqTutupKasir : UIEvent()
    }
}