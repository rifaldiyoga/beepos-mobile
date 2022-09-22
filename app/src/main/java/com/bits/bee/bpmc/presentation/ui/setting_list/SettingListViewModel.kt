package com.bits.bee.bpmc.presentation.ui.setting_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveUserUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.UpdateActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.setting.UpdateUserUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.login.LoginViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 05/04/22.
 */
@HiltViewModel
class SettingListViewModel @Inject constructor(
    private val getActiveUserUseCase: GetActiveUserUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val updateActiveCashierUseCase: UpdateActiveCashierUseCase
) : BaseViewModel<SettingListState, SettingListViewModel.UIEvent>() {

//    private val eventChannel = Channel<UIEvent>()
//    val event = eventChannel.receiveAsFlow()

    init {
        state = SettingListState()
    }

    fun onClickSettingPos() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSettingPos)
    }

    fun onClickSettingFavorit() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSettingFavorit)
    }

    fun onClickSettingNota() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSettingNota)
    }

    fun onClickSettingPrint() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSettingPrint)
    }

    fun onClickSettingSistem() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSettingSistem)
    }

    fun onClickHelp() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToDetailHelp)
    }

    fun onClickSettingLisensi() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSettingLisensi)
    }

    fun onClickKeluar() = viewModelScope.launch {
        getActiveUserUseCase().first()?.let {
            updateState(
                state.copy(
                    mUser = it
                )
            )
        }
        var user = state.mUser
        user!!.active = false
        updateUserUseCase.invoke(user)

        getActiveCashierUseCase().first()?.let {
            updateState(
                state.copy(
                    mCashier = it
                )
            )
        }
        var cashier = state.mCashier
        cashier!!.isActive = true
        updateActiveCashierUseCase.invoke(cashier)
        eventChannel.send(UIEvent.NavigateToLoginOperator)
    }

    sealed class UIEvent {
        object NavigateToSettingPos : UIEvent()
        object NavigateToSettingFavorit : UIEvent()
        object NavigateToSettingNota : UIEvent()
        object NavigateToSettingPrint : UIEvent()
        object NavigateToSettingSistem : UIEvent()
        object NavigateToSettingLisensi : UIEvent()
        object NavigateToLoginOperator : UIEvent()
        object NavigateToDetailHelp : UIEvent()
    }

}