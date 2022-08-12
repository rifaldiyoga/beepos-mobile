package com.bits.bee.bpmc.presentation.ui.pos.diskon_nota

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by aldi on 27/06/22.
 */
class DiskonNotaViewModel : BaseViewModel<DiskonNotaState, DiskonNotaViewModel.UIEvent>() {

    init {
        state = DiskonNotaState()
    }

    fun onTambahClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDiskonNota(state.diskon))
    }

    sealed class UIEvent {
        data class RequestDiskonNota(val diskon : String) : UIEvent()
    }

}