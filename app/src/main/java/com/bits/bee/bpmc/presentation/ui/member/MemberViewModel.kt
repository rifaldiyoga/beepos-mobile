package com.bits.bee.bpmc.presentation.ui.member

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.usecase.member.MemberInteractor
import com.bits.bee.bpmc.domain.usecase.member.SearchMemberUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 22/04/22.
 */
@HiltViewModel
class MemberViewModel @Inject constructor(
    memberInteractor: MemberInteractor,
    private val searchMemberUseCase: SearchMemberUseCase
): BaseViewModel<MemberState, MemberViewModel.UIEvent>() {

    init {
        state = MemberState()
    }

    val memberList = memberInteractor.getFavoritMemberUseCase()

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
        updateState(
            state.copy(
                search = query
            )
        )
        searchMemberUseCase.invoke(state.search).collect {
            when(it.status){
                Resource.Status.LOADING ->{
                    val str=""
                }
                Resource.Status.SUCCESS ->{
                    updateState(
                        state.copy(
                            listBp = it.data
                        )
                    )
                }
                Resource.Status.ERROR ->{

                }
            }
        }
    }

    sealed class UIEvent {
        object RequestAddMember : UIEvent()
        data class RequestPos(val model : Bp): UIEvent()
        data class RequestIconEye(val model: Bp): UIEvent()
    }

}