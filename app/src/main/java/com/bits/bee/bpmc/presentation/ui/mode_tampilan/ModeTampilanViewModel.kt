package com.bits.bee.bpmc.presentation.ui.mode_tampilan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 01/04/22.
 */
@HiltViewModel
class ModeTampilanViewModel @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager
) : ViewModel() {

    private val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    var type = "signin"


    fun onClickItem(string: String) = viewModelScope.launch {
        beePreferenceManager.updateModePreferences(string)
        eventChannel.send(UIEvent.RequestClickItem(string))
    }

    sealed class UIEvent {
        data class RequestClickItem(val mode : String) : UIEvent()
    }
}