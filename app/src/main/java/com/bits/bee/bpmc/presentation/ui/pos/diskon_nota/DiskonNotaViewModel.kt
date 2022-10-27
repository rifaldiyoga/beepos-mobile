package com.bits.bee.bpmc.presentation.ui.pos.diskon_nota

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.CalcUtils
import kotlinx.coroutines.launch

/**
 * Created by aldi on 27/06/22.
 */
class DiskonNotaViewModel : BaseViewModel<DiskonNotaState, DiskonNotaViewModel.UIEvent>() {

    init {
        state = DiskonNotaState()
    }

    fun onTambahClick() = viewModelScope.launch {
        try {
            val discAmt = CalcUtils.getDiscAmt(state.diskon, state.subtotal)

            if(state.subtotal < discAmt)
                throw Exception("Diskon melebihi subtotal!")

            eventChannel.send(UIEvent.RequestDiskonNota(state.diskon))
        } catch (e : Exception) {
            msgChannel.send(e.message ?: "")
        }
    }

    sealed class UIEvent {
        data class RequestDiskonNota(val diskon : String) : UIEvent()
    }

}