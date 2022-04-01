package com.bits.bee.bpmc.presentation.ui.mode_tampilan

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.utils.BeePreferenceManager
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * Created by aldi on 01/04/22.
 */
class ModeTampilanViewModel : ViewModel() {

    private val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    fun onClickItem(context : Context, string: String) = viewModelScope.launch {
        BeePreferenceManager.saveToPreferences(context, context.getString(R.string.pref_mode_tampilan), string)
        eventChannel.send(UIEvent.RequestClickItem(string))
    }

    sealed class UIEvent {
        data class RequestClickItem(val mode : String) : UIEvent()
    }
}