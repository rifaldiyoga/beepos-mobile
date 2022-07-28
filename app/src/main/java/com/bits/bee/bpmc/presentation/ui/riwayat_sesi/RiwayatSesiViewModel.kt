package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetFilterSesiUseCase
import com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetPossesHistoryUseCase
import com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetSortingUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir.RekapSesiViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RiwayatSesiViewModel @Inject constructor(
    private val getPossesHistoryUseCase: GetPossesHistoryUseCase,
    private val getSortingUseCase: GetSortingUseCase,
    private val getFilterSesiUseCase: GetFilterSesiUseCase
): BaseViewModel<RiwayatSesiState, RiwayatSesiViewModel.UIEvent>() {

    init {
        state = RiwayatSesiState()
    }

    var possesList : Flow<PagingData<Posses>> = MutableSharedFlow(1)
    var possesSort : Flow<PagingData<Posses>> = MutableSharedFlow(1)
    var possesFilter: Flow<PagingData<Posses>> = MutableSharedFlow(1)

    fun getHistory() = viewModelScope.launch {
        possesList = getPossesHistoryUseCase.invoke()
    }

    fun getSorting(desc: Boolean) = viewModelScope.launch {
        possesSort = getSortingUseCase.invoke(desc)
    }

    fun getFilterDays(currwnt: Long, yester: Long) = viewModelScope.launch {
        val startDate = Calendar.getInstance()
        val endDate = Calendar.getInstance()
        getFilterSesiUseCase.invoke(currwnt, yester)
    }

    fun showDialog() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDialogFilter)
    }

    sealed class UIEvent {
        object RequestDialogFilter : UIEvent()
    }
}