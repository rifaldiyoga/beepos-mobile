package com.bits.bee.bpmc.presentation.ui.member

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.usecase.member.GetActiveMemberUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 22/04/22.
 */
@HiltViewModel
class MemberViewModel @Inject constructor(
    private val getActiveMemberUseCase: GetActiveMemberUseCase,
): BaseViewModel<MemberState, MemberViewModel.UIEvent>() {

    val currentQuery = MutableStateFlow("")

    init {
        state = MemberState()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val memberList = combine(
        currentQuery,
    ) { (query) ->
       QueryWithSort(query)
    }.flatMapLatest {
        getActiveMemberUseCase(it.query, it.fav).cachedIn(viewModelScope)
    }

    fun onClickDetailMember(model : Bp) = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestPos(model))
    }

    fun onClickEye(model: Bp) = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestIconEye(model))
    }

    fun onClickAddMember() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestAddMember)
    }


    fun onSearch(query: String) = viewModelScope.launch{
        currentQuery.value = query
    }

    data class QueryWithSort(
        val query: String,
        val fav : Boolean = false
    )

    sealed class UIEvent {
        object RequestAddMember : UIEvent()
        data class RequestPos(val model : Bp): UIEvent()
        data class RequestIconEye(val model: Bp): UIEvent()
    }

}