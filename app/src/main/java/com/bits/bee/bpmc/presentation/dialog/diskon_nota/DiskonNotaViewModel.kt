package com.bits.bee.bpmc.presentation.dialog.diskon_nota

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.helper.PrivilegeHelper
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.pos.edit_item.EditItemViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.CalcUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 27/06/22.
 */
@HiltViewModel
class DiskonNotaViewModel @Inject constructor(
    private val privilegeHelper: PrivilegeHelper
): BaseViewModel<DiskonNotaState, DiskonNotaViewModel.UIEvent>() {

    init {
        state = DiskonNotaState()
    }

    fun loadData() = viewModelScope.launch {
        state.isEditDisc = privilegeHelper.hasAccess(BPMConstants.BPM_PRIVILEGE_OBJ, BPMConstants.ACS_DISC_MASTER)
    }

    fun onDiscFocus() = viewModelScope.launch {
        if(!state.isEditDisc){
            eventChannel.send(UIEvent.NavigateToHakAkses)
        }
    }

    fun onTambahClick() = viewModelScope.launch {
        try {
            val discAmt = CalcUtils.getDiscAmt(state.diskon, state.subtotal)

            if(state.subtotal == BigDecimal.ZERO || state.subtotal < discAmt)
                throw Exception("Diskon melebihi subtotal!")

            eventChannel.send(UIEvent.RequestDiskonNota(state.diskon))
        } catch (e : Exception) {
            msgChannel.send(e.message ?: "")
        }
    }

    sealed class UIEvent {
        data class RequestDiskonNota(val diskon : String) : UIEvent()
        object NavigateToHakAkses : UIEvent()
    }

}