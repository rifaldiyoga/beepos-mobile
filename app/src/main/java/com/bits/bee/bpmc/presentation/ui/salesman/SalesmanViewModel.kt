package com.bits.bee.bpmc.presentation.ui.salesman

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Srep
import com.bits.bee.bpmc.domain.usecase.salesman.GetSalesmanUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.member.MemberViewModel
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
class SalesmanViewModel @Inject constructor(
    private val getSalesmanUseCase: GetSalesmanUseCase,
): BaseViewModel<SalesmanState, SalesmanViewModel.UIEvent>() {

    val currentQuery = MutableStateFlow("")

    init {
        state = SalesmanState()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val memberList = combine(
        currentQuery,
    ) { (query) ->
        QueryWithSort(query)
    }.flatMapLatest {
        getSalesmanUseCase(it.query)
    }


    fun onClickDetailMember(model : Srep) = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestPos(model))
    }

    fun onClickEye(model: Srep) = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestIconEye(model))
    }

    fun onSearch(query: String) = viewModelScope.launch {
        currentQuery.value = query
    }

    data class QueryWithSort(
        val query: String,
    )

    sealed class UIEvent {
        data class RequestPos(val model : Srep): UIEvent()
        data class RequestIconEye(val model: Srep): UIEvent()
    }

}