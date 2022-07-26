package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetPossesHistoryUseCase
import com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetSortingUseCase
import com.bits.bee.bpmc.domain.usecase.riwayat_sesi.SearchRiwayatSesiUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir.RekapSesiViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RiwayatSesiViewModel @Inject constructor(
    private val getPossesHistoryUseCase: GetPossesHistoryUseCase,
    private val searchRiwayatSesiUseCase: SearchRiwayatSesiUseCase,
    private val getSortingUseCase: GetSortingUseCase
): BaseViewModel<RiwayatSesiState, RekapSesiViewModel.UIEvent>() {

    init {
        state = RiwayatSesiState()
    }

    var possesList : Flow<PagingData<Posses>> = MutableSharedFlow(1)
    var possesSort : Flow<PagingData<Posses>> = MutableSharedFlow(1)

    fun getHistory() = viewModelScope.launch {
        possesList = getPossesHistoryUseCase.invoke()
    }

    fun getSorting(desc: Boolean) = viewModelScope.launch {
        possesSort = getSortingUseCase.invoke(desc)
    }

    fun onSearch(search: String) = viewModelScope.launch {
        updateState(
            state.copy(
                search = search
            )
        )
        searchRiwayatSesiUseCase.invoke(state.search).collect {
            updateState(
                state.copy(
                    listPosses = it
                )
            )
        }
    }

    sealed class UIEvent {
        object RequestInfoTax : UIEvent()
    }
}