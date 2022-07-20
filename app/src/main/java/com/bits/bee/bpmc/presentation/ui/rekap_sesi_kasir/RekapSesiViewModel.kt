package com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetDefaultUserUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetListPossesUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RekapSesiViewModel @Inject constructor(
    private val getListPossesUseCase: GetListPossesUseCase,
    private val getDefaultUserUseCase: GetDefaultUserUseCase
): BaseViewModel<RekapSesiState, RekapSesiViewModel.UIEvent>() {

    private var mPosses:  Posses? = null

    init {
        state = RekapSesiState()
    }

    var possesList : Flow<PagingData<Posses>> = MutableSharedFlow(1)

    fun getUser() = viewModelScope.launch {
        getDefaultUserUseCase.invoke().collect {
            when(it.status){
                Resource.Status.LOADING ->{
                    val str=""
                }
                Resource.Status.SUCCESS ->{
                    updateState(
                        state.copy(
                            user = it.data
                        )
                    )
                }
                Resource.Status.ERROR ->{

                }
            }
        }
    }

    fun getRekapsesi() = viewModelScope.launch {
        possesList =  getListPossesUseCase.invoke()
    }

    sealed class UIEvent {
        object RequestInfoTax : UIEvent()
    }
}