package com.bits.bee.bpmc.presentation.dialog.detail_member

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.usecase.member.GetBpAddrByBpUseCase
import com.bits.bee.bpmc.domain.usecase.member.GetRegencyByCodeUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 27/04/22.
 */
@HiltViewModel
class DetailMemberViewModel @Inject constructor(
    private val getBpAddrByBpUseCase: GetBpAddrByBpUseCase,
    private val getRegencyByCodeUseCase: GetRegencyByCodeUseCase
): BaseViewModel<DetailMemberState, DetailMemberViewModel.UIEvent>() {

    init {
        state = DetailMemberState()
    }

    fun setOnClickInfoTax() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestInfoTax)
    }

    fun setOnClickInfo() = viewModelScope.launch {
        _state.update {
            it!!.copy(
                isInfoLainnya = !state.isInfoLainnya
            )
        }
    }

    fun update(data: Bp) = viewModelScope.launch {
        _state.update {
            it!!.copy(
                bp = data
            )
        }
    }

    fun getBpaddr() = viewModelScope.launch{
        getBpAddrByBpUseCase.invoke(state.bp!!.id!!).collect {
            when(it.status){
                Resource.Status.LOADING ->{
                    val str=""
                }
                Resource.Status.SUCCESS ->{
                    updateState(
                        state.copy(bpAdddr= it.data)
                    )
                }
                Resource.Status.ERROR ->{
                    val str=""
                }
            }
        }
        getRegencyByCodeUseCase.invoke(state.bpAdddr!!.regencyCode).collect {
            when(it.status){
                Resource.Status.LOADING ->{
                    val str=""
                }
                Resource.Status.SUCCESS ->{
                    updateState(
                        state.copy(regency = it.data)
                    )
                }
                Resource.Status.ERROR ->{
                    val str=""
                }
            }
        }
    }

    sealed class UIEvent {
        object RequestInfoTax : UIEvent()
    }

}