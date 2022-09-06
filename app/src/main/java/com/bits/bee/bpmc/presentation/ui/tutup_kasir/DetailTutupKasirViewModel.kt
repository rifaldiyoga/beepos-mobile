package com.bits.bee.bpmc.presentation.ui.tutup_kasir

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by aldi on 08/06/22.
 */

class DetailTutupKasirViewModel (
): BaseViewModel<DetailTutupKasirState, DetailTutupKasirViewModel.UIEvent>() {

    init {
        state = DetailTutupKasirState()
    }

    fun onTutupKasir() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestSave)
    }

      fun onCLickMenu() = viewModelScope.launch{
          eventChannel.send(UIEvent.RequestRekapSesi)
      }

    sealed class UIEvent {
        object RequestSave : UIEvent()
        object RequestRekapSesi : UIEvent()
    }
}
