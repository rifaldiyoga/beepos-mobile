package com.bits.bee.bpmc.presentation.ui.salesman

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Srep
import com.bits.bee.bpmc.domain.usecase.member.SearchMemberUseCase
import com.bits.bee.bpmc.domain.usecase.salesman.GetSalesmanUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 22/04/22.
 */
@HiltViewModel
class SalesmanViewModel @Inject constructor(
    private val getSalesmanUseCase: GetSalesmanUseCase,
    private val searchMemberUseCase: SearchMemberUseCase
): BaseViewModel<SalesmanState, SalesmanViewModel.UIEvent>() {

    init {
        state = SalesmanState()
    }

    val memberList = getSalesmanUseCase()

    fun onClickDetailMember(model : Srep) = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestPos(model))
    }

    fun onClickEye(model: Srep) = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestIconEye(model))
    }

    fun onSearch(query: String) = viewModelScope.launch{
        updateState(
            state.copy(
                search = query
            )
        )
//        searchMemberUseCase.invoke(state.search).collect {
//            when(it.status){
//                Resource.Status.LOADING ->{
////                    val str=""
//                }
//                Resource.Status.SUCCESS ->{
//                    updateState(
//                        state.copy(
//                            listSrep = it.data
//                        )
//                    )
//                }
//                Resource.Status.ERROR ->{
//
//                }
//            }
//        }
    }

    sealed class UIEvent {
        data class RequestPos(val model : Srep): UIEvent()
        data class RequestIconEye(val model: Srep): UIEvent()
    }

}