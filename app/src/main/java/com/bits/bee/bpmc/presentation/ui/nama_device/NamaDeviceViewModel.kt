package com.bits.bee.bpmc.presentation.ui.nama_device

import android.content.Context
import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 21/03/22.
 */
@HiltViewModel
class NamaDeviceViewModel @Inject constructor(

): ViewModel() {

    private val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    private val _state = MutableStateFlow(NamaDeviceState())
    val state = _state.asStateFlow()

    fun onArgumentRecived(email : String, password : String) = viewModelScope.launch {
        _state.update {
            it.copy(email, password)
        }
    }

    fun onInputName(deviceName : String) = viewModelScope.launch {
        _state.update {
            it.copy(deviceName = deviceName)
        }
    }

    fun onClickLanjutkan(context: Context) = viewModelScope.launch {
        BeePreferenceManager.saveToPreferences(context, context.getString(R.string.pref_nama_device), Build.MANUFACTURER + Build.ID + "-"+state.value.deviceName)
        eventChannel.send(UIEvent.NavigateToPilihDb(state.value.email, state.value.password))
    }

    sealed class UIEvent{
        data class NavigateToPilihDb(val username : String, val password: String) : UIEvent()
    }

}