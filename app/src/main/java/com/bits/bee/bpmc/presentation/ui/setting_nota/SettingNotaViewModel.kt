package com.bits.bee.bpmc.presentation.ui.setting_nota

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingNotaViewModel @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager
): BaseViewModel<SettingNotaState, SettingNotaViewModel.UIEvent>() {

    val notaPreferences = beePreferenceManager.notaPreferences

    init {
        state = SettingNotaState()
    }

    fun onClickLogo(value: Boolean) = viewModelScope.launch {
        onUpdateNotaPreferences(notaPreferences.first().copy(
            isLoadLogo = value
        ))
    }

    fun onClickHeader(value: Boolean) = viewModelScope.launch {
        onUpdateNotaPreferences(notaPreferences.first().copy(
            isHeader = value
        ))
    }

    fun onClickFooter(value: Boolean) = viewModelScope.launch {
        onUpdateNotaPreferences(notaPreferences.first().copy(
            isFooter = value
        ))
    }

    fun onClickRekapCust(value: Boolean) = viewModelScope.launch {
        onUpdateNotaPreferences(notaPreferences.first().copy(
            isRekapCust = value
        ))
    }


    fun onClickRekapItem(value: Boolean) = viewModelScope.launch {
        onUpdateNotaPreferences(notaPreferences.first().copy(
            isRekapItem = value
        ))
    }

    fun onClickRekapItemChannel(value: Boolean) = viewModelScope.launch {
        onUpdateNotaPreferences(notaPreferences.first().copy(
            isRekapItemChannel = value
        ))
    }

    fun onClickRekapChannel(value: Boolean) = viewModelScope.launch {
        onUpdateNotaPreferences(notaPreferences.first().copy(
            isRekapChannel = value
        ))
    }

    fun onClickRekapFaktur(value: Boolean) = viewModelScope.launch {
        onUpdateNotaPreferences(notaPreferences.first().copy(
            isRekapFaktur = value
        ))
    }

    fun onClickAturHeader() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestAturHeader)
    }

    fun onClickAturFooter() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestAturFooter)
    }

    fun onSuccessFooter(value : String) = viewModelScope.launch {
        onUpdateNotaPreferences(notaPreferences.first().copy(
            footer = value
        ))
    }

    fun onSuccessHeader(value : String) = viewModelScope.launch {
        onUpdateNotaPreferences(notaPreferences.first().copy(
            header = value
        ))
    }

    private fun onUpdateNotaPreferences(posPreferences: BeePreferenceManager.NotaPreferences) = viewModelScope.launch {
        beePreferenceManager.updateNotaPreferences(posPreferences)
    }

    sealed class UIEvent{
        object RequestAturHeader : UIEvent()
        object RequestAturFooter : UIEvent()
    }
}