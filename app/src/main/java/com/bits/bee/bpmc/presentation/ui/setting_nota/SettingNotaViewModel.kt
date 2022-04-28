package com.bits.bee.bpmc.presentation.ui.setting_nota

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
): ViewModel() {
    private val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    private var _state = MutableStateFlow(SettingNotaState())
    var state = _state.asStateFlow()

    fun onSwitchLogo(){
        _state.update { it.copy(useLogo = true) }
    }

    fun offSwitchLogo(){
        _state.update {it.copy(useLogo = false)}
    }

    fun onSwitchLogoGaleri(){
        _state.update { it.copy(useLogoGalery = true) }
    }

    fun offSwitchLogoGaleri(){
        _state.update { it.copy(useLogoGalery = false, filePath = BeePreferenceManager.getDataFromPreferences(application, BPMConstants.NOTASETTING_LOGOPATH, "") as String) }
    }

    fun onSwitchHeader(){
        _state.update { it.copy(useHeader = true) }
    }

    fun offSwitchHeader(){
        _state.update { it.copy(useHeader = false) }
    }

    fun onSwitchFooter(){
        _state.update { it.copy(useFooter = true) }
    }

    fun offSwitchFooter(){
        _state.update { it.copy(useFooter = false) }
    }

    fun getFilePath(){
        _state.update { it.copy(filePath = BeePreferenceManager.getDataFromPreferences(application, BPMConstants.NOTASETTING_LOGOPATH, "") as String) }
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