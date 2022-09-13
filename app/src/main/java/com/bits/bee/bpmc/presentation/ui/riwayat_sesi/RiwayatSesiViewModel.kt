package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.Sesi
import com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetPossesByDateUseCase
import com.bits.bee.bpmc.domain.usecase.riwayat_sesi.*
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
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

    init {
        state = RiwayatSesiState()
    }

//    var possesList : Flow<PagingData<Posses>> = MutableSharedFlow(1)
//    var possesSort : Flow<PagingData<Posses>> = MutableSharedFlow(1)
//    var possesFilter: Flow<PagingData<Posses>> = MutableSharedFlow(1)
//    val getListHistory = getListPossesHistoryUseCase.invoke()

    fun getHistory() = viewModelScope.launch {
//        possesList = getPossesHistoryUseCase.invoke()
    }

    fun getFilterSorting(desc: Boolean, filter: Int, selectFilter: String) = viewModelScope.launch {
        val startDate = Calendar.getInstance()
        val endDate = Calendar.getInstance()
        var startRangeTime: Long? = null
        var endRangeTime: Long? = null
        updateState(
            state.copy(
                isDesc = desc
            )
        )
        if (filter == 0){
            startDate.add(Calendar.DAY_OF_MONTH, -6)
        }else if (filter == 1){
            startDate.add(Calendar.MONTH, -1)
        }else if (filter == 2){
            startDate.add(Calendar.MONTH, -3)
        }else if (filter == 3){
            val rangeDate = selectFilter.split(" - ").toTypedArray()
            val startRange = rangeDate[0]
            val endRange = rangeDate[1]
            val startDateRange = DateFormatUtils.formatStringToDate(BPMConstants.NEW_DATE_FORMAT, startRange)
            val endDateRange = DateFormatUtils.formatStringToDate(BPMConstants.NEW_DATE_FORMAT, endRange)
            startRangeTime = DateFormatUtils.formatDateToLong(BPMConstants.NEW_DATE_FORMAT, startDateRange)
            endRangeTime = DateFormatUtils.formatDateToLong(BPMConstants.NEW_DATE_FORMAT, endDateRange)
        }
        getFilterSortingUseCase.invoke(desc, DateFormatUtils.convertStartDate((if (filter == 3) startRangeTime else startDate.timeInMillis)!!),
            DateFormatUtils.convertEndDate((if (filter == 3) endRangeTime!! else endDate.timeInMillis))).collect {
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