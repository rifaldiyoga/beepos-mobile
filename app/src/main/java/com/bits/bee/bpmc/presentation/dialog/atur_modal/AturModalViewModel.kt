package com.bits.bee.bpmc.presentation.dialog.atur_modal

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.buka_kasir.BukaKasirUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.buka_kasir.DetailBukaKasirViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 09/06/22.
 */
@HiltViewModel
class AturModalViewModel @Inject constructor(
) : BaseViewModel<AturModalState, AturModalViewModel.UIEvent>(){

    init {
        state = AturModalState()
    }

    fun onBukaKasirClick() = viewModelScope.launch {
        if (state.modal.isNotEmpty()) {
            eventChannel.send(UIEvent.RequestSave)
        } else {
            eventChannel.send(UIEvent.NavigateToDefaultModal)
        }
    }

    fun saveBukaKasir() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestSave)
    }

    fun onDoneSave() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPos)
    }

    fun onInsight() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToInsight)
    }


    sealed class UIEvent {
        object NavigateToPos : UIEvent()
        object NavigateToDefaultModal : UIEvent()
        object NavigateToInsight : UIEvent()
        object RequestSave : UIEvent()
    }
}