package com.bits.bee.bpmc.presentation.dialog.detail_salesman

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Srep
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 27/04/22.
 */
@HiltViewModel
class DetailSalesmanViewModel @Inject constructor(
): BaseViewModel<DetailSalesmanState, DetailSalesmanViewModel.UIEvent>() {

    init {
        state = DetailSalesmanState()
    }

    fun setOnClickInfoTax() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestInfoTax)
    }

    fun setOnClickInfo() = viewModelScope.launch {
        updateState(
            state.copy(
                isInfoLainnya = !state.isInfoLainnya
            )
        )
    }

    fun update(data: Srep) = viewModelScope.launch {
        updateState(
            state.copy(
                srep = data
            )
        )
    }
//
//    fun getBpaddr() = viewModelScope.launch{
//        getBpAddrByBpUseCase.invoke(state.bp!!.id!!).collect {
//            when(it.status){
//                Resource.Status.LOADING ->{
//
//                }
//                Resource.Status.SUCCESS ->{
//                    updateState(
//                        state.copy(
//                            bpAdddr = it.data
//                        )
//                    )
//                }
//                Resource.Status.ERROR ->{
//
//                }
//            }
//        }
//        if (!state.bpAdddr!!.regencyCode.equals("")){
//            getRegencyByCodeUseCase.invoke(state.bpAdddr!!.regencyCode).collect {
//                when(it.status){
//                    Resource.Status.LOADING ->{
//
//                    }
//                    Resource.Status.SUCCESS ->{
//                        updateState(
//                            state.copy(regency = it.data)
//                        )
//                    }
//                    Resource.Status.ERROR ->{
//
//                    }
//                }
//            }
//            if (!state.bpAdddr!!.districtCode.equals("")){
//                getDistrictByCodeUseCase.invoke(state.bpAdddr!!.districtCode).collect {
//                    when(it.status){
//                        Resource.Status.LOADING ->{
//
//                        }
//                        Resource.Status.SUCCESS ->{
//                            updateState(
//                                state.copy(district = it.data)
//                            )
//                        }
//                        Resource.Status.ERROR ->{
//
//                        }
//                    }
//                }
//            }
//        }
//    }

    sealed class UIEvent {
        object RequestInfoTax : UIEvent()
    }

}