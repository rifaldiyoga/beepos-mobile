package com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.usecase.common.GetActiveUserUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetListPossesUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RekapSesiViewModel @Inject constructor(
    private val getListPossesUseCase: GetListPossesUseCase,
    private val getActiveUserUseCase: GetActiveUserUseCase
): BaseViewModel<RekapSesiState, RekapSesiViewModel.UIEvent>() {

    private var mPosses:  Posses? = null

    init {
        state = RekapSesiState()
    }

    var possesList : Flow<PagingData<Posses>> = MutableSharedFlow(1)

    fun getUser() = viewModelScope.launch {
        getActiveUserUseCase.invoke().collect {
            updateState(
                state.copy(
                    user = it
                )
            )
        }
    }

    fun getRekapsesi() = viewModelScope.launch {
        possesList =  getListPossesUseCase.invoke()
    }

    sealed class UIEvent {
        object RequestInfoTax : UIEvent()
    }
}