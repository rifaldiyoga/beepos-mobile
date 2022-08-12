package com.bits.bee.bpmc.presentation.ui.setting_nota

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemState
import com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingNotaViewModel @Inject constructor(
    @ApplicationContext val application: Context
): BaseViewModel<SettingNotaState, SettingNotaViewModel.UIEvent>() {

    init {
        state = SettingNotaState()
    }

    fun onClickAturHeader() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestAturHeader)
    }

    fun onClickAturFooter() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestAturFooter)
    }

    sealed class UIEvent{
        object RequestAturHeader : UIEvent()
        object RequestAturFooter : UIEvent()
    }
}