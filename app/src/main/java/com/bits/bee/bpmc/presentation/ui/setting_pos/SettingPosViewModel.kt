package com.bits.bee.bpmc.presentation.ui.setting_pos

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 05/04/22.
 */
@HiltViewModel
class SettingPosViewModel @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager
) : BaseViewModel<SettingPosViewState, SettingPosViewModel.UIEvent>() {

    val posPreferences = beePreferenceManager.posPreferences

    init {
        state = SettingPosViewState()

    }

    fun onClickUkuranFont() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestUkuranFont)
    }

    fun onClickCustomer() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestCustomer)
    }

    fun onClickJumlahMeja() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestJumlahMeja)
    }

    fun onClickPresetBukaKasir() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestPresetBukaKasir)
    }

    fun onClickPosisiOrientasi() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestPosisiOrientasi)
    }

    fun onClickMultiLine(value: Boolean) = viewModelScope.launch {
        onUpdatePosPreferences(posPreferences.first().copy(
            isMultiLine = value
        ))
    }

    fun onClickKonfirmasiCust(value : Boolean) = viewModelScope.launch {
        onUpdatePosPreferences(posPreferences.first().copy(
            isKonfirmasiCust = value
        ))
    }

    fun onClickMuatGambar(value: Boolean) = viewModelScope.launch {
        onUpdatePosPreferences(posPreferences.first().copy(
            isMuatGambar = value
        ))
    }

    fun onSuccessUkuranFont(value : String) = viewModelScope.launch {
        onUpdatePosPreferences(posPreferences.first().copy(
            ukuranFont = value
        ))
    }

    fun onSuccessCustomer(value : String) = viewModelScope.launch {
        onUpdatePosPreferences(posPreferences.first().copy(
            customer = value
        ))
    }

    fun onSuccessJumlahMeja(value : String) = viewModelScope.launch {
        onUpdatePosPreferences(posPreferences.first().copy(
            jumlahMeja = value
        ))
    }

    fun onSuccessOrientasi(value : String) = viewModelScope.launch {
        onUpdatePosPreferences(posPreferences.first().copy(
            orientasi = value
        ))
    }

    fun onSuccessPresetBukaKasir(value : String) = viewModelScope.launch {
        onUpdatePosPreferences(posPreferences.first().copy(
            presetBukaKasir = value
        ))
    }

    fun onUpdatePosPreferences(posPreferences: BeePreferenceManager.PosPreferences) = viewModelScope.launch {
        beePreferenceManager.updatePosPreferences(posPreferences)
    }

    sealed class UIEvent{
        object RequestUkuranFont : UIEvent()
        object RequestCustomer : UIEvent()
        object RequestJumlahMeja : UIEvent()
        object RequestPresetBukaKasir : UIEvent()
        object RequestPosisiOrientasi : UIEvent()

    }

}