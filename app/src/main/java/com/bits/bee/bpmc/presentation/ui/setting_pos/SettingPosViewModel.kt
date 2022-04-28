package com.bits.bee.bpmc.presentation.ui.setting_pos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 05/04/22.
 */
@HiltViewModel
class SettingPosViewModel @Inject constructor(

) : ViewModel() {

    private val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    private var _state = MutableStateFlow(SettingPosViewState())
    var state = _state.asStateFlow()

//    private lateinit var _state : MutableStateFlow<SettingPosState> = MutableStateFlow(
//        SettingPosState()
//    )
//    var state = _state.asStateFlow()

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

    sealed class UIEvent{
        object RequestUkuranFont : UIEvent()
        object RequestCustomer : UIEvent()
        object RequestJumlahMeja : UIEvent()
        object RequestPresetBukaKasir : UIEvent()
        object RequestPosisiOrientasi : UIEvent()

    }

}