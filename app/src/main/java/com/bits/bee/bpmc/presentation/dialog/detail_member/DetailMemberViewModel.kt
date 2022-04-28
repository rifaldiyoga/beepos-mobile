package com.bits.bee.bpmc.presentation.dialog.detail_member

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 27/04/22.
 */
@HiltViewModel
class DetailMemberViewModel @Inject constructor(

): BaseViewModel() {

    private val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    private val _state = MutableStateFlow(DetailMemberState())
    var state = _state.asStateFlow()

    fun setOnClickInfoTax() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestInfoTax)
    }

    fun setOnClickInfo() = viewModelScope.launch {
        _state.update {
            it.copy(
                isInfoLainnya = !state.value.isInfoLainnya
            )
        }
    }

    fun update(data: Bp) = viewModelScope.launch {
        _state.update {
            it.copy(
                bp = data
            )
        }
    }

    sealed class UIEvent {
        object RequestInfoTax : UIEvent()
    }

}