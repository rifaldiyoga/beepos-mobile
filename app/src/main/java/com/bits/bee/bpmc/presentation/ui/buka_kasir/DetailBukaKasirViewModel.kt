package com.bits.bee.bpmc.presentation.ui.buka_kasir

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 08/06/22.
 */
@HiltViewModel
class DetailBukaKasirViewModel @Inject constructor(
): BaseViewModel<DetailBukaKasirState, DetailBukaKasirViewModel.UIEvent>() {

    init {
        state = DetailBukaKasirState()
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
        object NavigateToDefaultModal : UIEvent()
        object NavigateToPos : UIEvent()
        object NavigateToInsight : UIEvent()
        object RequestSave : UIEvent()
    }
}