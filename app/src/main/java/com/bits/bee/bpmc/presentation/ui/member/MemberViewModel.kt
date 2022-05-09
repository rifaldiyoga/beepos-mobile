package com.bits.bee.bpmc.presentation.ui.member

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.usecase.member.MemberInteractor
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 22/04/22.
 */
@HiltViewModel
class MemberViewModel @Inject constructor(
    val memberInteractor: MemberInteractor,
): ViewModel() {

    private val eventChannel = Channel<UIEvent>()
    val event = eventChannel.receiveAsFlow()

    val memberList = memberInteractor.getFavoritMemberUseCase.invoke()

    fun onClickDetailMember(model : Bp) = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDetailMember(model))
    }

    fun onClickAddMember() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestAddMember)
    }

    sealed class UIEvent {
        object RequestAddMember : UIEvent()
        data class RequestDetailMember(val model : Bp): UIEvent()
    }

}