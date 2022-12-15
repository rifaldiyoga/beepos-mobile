package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.FilterDate
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.Sesi
import com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetPossesByDateUseCase
import com.bits.bee.bpmc.domain.usecase.riwayat_sesi.*
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.bits.bee.bpmc.utils.FilterUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RiwayatSesiViewModel @Inject constructor(
    private val getPossesHistoryUseCase: GetPossesHistoryUseCase,
    private val getFilterSesiUseCase: GetFilterSesiUseCase,
    private val getListPossesHistoryUseCase: GetListPossesHistoryUseCase,
    private val getPossesByDateUseCase: GetPossesByDateUseCase,
    private val getFilterSortingUseCase: GetFilterSortingUseCase
): BaseViewModel<RiwayatSesiState, RiwayatSesiViewModel.UIEvent>() {
//    private var possesMap : HashMap<Long, MutableList<Posses>>
//            = HashMap()
//    private var sesi: MutableList<Sesi> = mutableListOf()
    var filterDate : MutableStateFlow<FilterDate> = MutableStateFlow(FilterUtils.getFilterDate(
    0,
    "",
    false
))

    init {
        state = RiwayatSesiState()
    }



    fun getFilterSorting(desc: Boolean, filter : FilterDate) = viewModelScope.launch {
        filterDate.value = filter
        updateState(
            state.copy(
                isDesc = desc
            )
        )
        getFilterSortingUseCase.invoke(desc, filter.startDate, filter.endDate).collect {
                it.data?.let {
                    updateState(
                        state.copy(
                            listHistoryPosses = it
                        )
                    )
                }
        }

    }

    fun setListSesi(list: List<Posses>, desc: Boolean) {
        val possesMap : HashMap<Long, MutableList<Posses>>
                = HashMap()
        possesMap.clear()
        val resultSorted: SortedMap<Long, MutableList<Posses>>
        for (posses in list){
            val key = DateFormatUtils.convertStartDate(posses.trxDate.time)
            if (!possesMap.containsKey(key)){
                val mutable: MutableList<Posses> = mutableListOf()
                mutable.add(posses)
                    possesMap.put(key, mutable)
            }else{
                possesMap.get(key)!!.add(posses)
            }
        }
        if (state.isDesc){
            resultSorted = possesMap.toSortedMap(compareByDescending { it })
        }else{
            resultSorted = possesMap.toSortedMap(compareBy { it })
        }
        parseMapPosses(resultSorted, desc)
    }

    private fun parseMapPosses(possesMap: SortedMap<Long, MutableList<Posses>>, desc: Boolean) = viewModelScope.launch{
        var jmlTrans = 0
        val sesiList = mutableListOf<Sesi>()
        for (newMap in possesMap.entries){
            getPossesByDateUseCase.invoke(DateFormatUtils.convertStartDate(newMap.key), DateFormatUtils.convertEndDate(newMap.key)).collect {
                it.data?.let {
                    jmlTrans = it.size
                }
            }
            sesiList.add(Sesi(newMap.key, newMap.value, jmlTrans))
        }

        updateState(
            state.copy(
                sesiList = sesiList
            )
        )
    }

    fun showDialog() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDialogFilter)
    }

    sealed class UIEvent {
        object RequestDialogFilter : UIEvent()
    }
}