package com.bits.bee.bpmc.presentation.dialog.channel_filter

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveChannelUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 24/06/22.
 */
@HiltViewModel
class ChannelFilterListViewModel @Inject constructor(
    private val getActiveChannelUseCase: GetActiveChannelUseCase
) : BaseViewModel<ChannelFilterListDialogState, ChannelFilterListViewModel.UIEvent>() {

    init {
        state = ChannelFilterListDialogState()
    }

    fun onItemClick(channel : Channel) = viewModelScope.launch {
        val channelList = mutableListOf<Channel>()
        channelList.addAll(state.channelList)
        channelList.forEach {
            if(it == channel) {
                it.isSelected = !it.isSelected
            }
        }
        updateState(
            state.copy(
                channelList = channelList
            )
        )
    }

    fun onResetClick() = viewModelScope.launch {
        updateState(
            state.copy(
                channelList = state.channelList.map { it.copy(isSelected = false) }
            )
        )
    }

    fun getChannelList() = viewModelScope.launch {
        val channelList = getActiveChannelUseCase().first()
        channelList.forEach {
            if(state.selectedChannelList.map { it.id }.contains(it.id))
                it.isSelected = true
        }
        updateState(
            state.copy(
                channelList = channelList
            )
        )
    }

    sealed class UIEvent {
        data class RequestChannel(val sale : Channel) : UIEvent()
    }

}