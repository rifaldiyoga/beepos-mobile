package com.bits.bee.bpmc.presentation.ui.hak_akses

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.helper.PrivilegeHelper
import com.bits.bee.bpmc.domain.model.User
import com.bits.bee.bpmc.domain.usecase.login.operator.GetUserPinUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.login_operator.LoginOperatorViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 01/11/22
 */
@HiltViewModel
class HakAksesViewModel @Inject constructor(
    private val getUserPinUseCase: GetUserPinUseCase,
    private val privilegeHelper: PrivilegeHelper
): BaseViewModel<HakAksesState, HakAksesViewModel.UIEvent>() {

    init {
        state = HakAksesState()
    }

    fun checkPinUser(pin: String) = viewModelScope.launch {
        val user = getUserPinUseCase.invoke(pin).first().firstOrNull()

        user?.let {
            if(privilegeHelper.hasAccess(BPMConstants.BPM_PRIVILEGE_OBJ, state.acsType, it.id)) {
                sendMessage("Terauth")
                eventChannel.send(UIEvent.SuccessValididation)
            } else {
                sendMessage("User tidak Memiliki akses")
                eventChannel.send(UIEvent.ClearPin)
            }
        } ?: run {
            state.mTimesWrong = state.mTimesWrong + 1
            sendMessage("Tidak terauth")
            eventChannel.send(UIEvent.ClearPin)
            if (state.mTimesWrong == 2){
                eventChannel.send(UIEvent.RequetWarningPass)
            }
        }
    }

    fun onSuccessValidate() = viewModelScope.launch {
        eventChannel.send(UIEvent.SuccessValididation)
    }

    sealed class UIEvent {
        object ClearPin : UIEvent()
        object RequetWarningPass : UIEvent()
        object SuccessValididation : UIEvent()
    }

}