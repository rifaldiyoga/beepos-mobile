package com.bits.bee.bpmc.presentation.ui.rekap_produk

import android.annotation.SuppressLint
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.usecase.pos.GetPidByItemUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_produk.FilterSearchItemUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_produk.GetPidUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_produk.LoadCariItemsUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_produk.QueryRekapProdukUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RekapProdukViewModel @Inject constructor(
    private val queryRekapProdukUseCase: QueryRekapProdukUseCase,
    private val loadCariItemsUseCase: LoadCariItemsUseCase,
    private val filterSearchItemUseCase: FilterSearchItemUseCase,
    private val getPidByItemUseCase: GetPidByItemUseCase
): BaseViewModel<RekapProdukState, RekapProdukViewModel.UIEvent>() {

    init {
        state = RekapProdukState()
    }

    fun loadRekapProduk(filter: Int, selectFilter: String, query: String) = viewModelScope.launch {
        val startDate = Calendar.getInstance()
        val endDate = Calendar.getInstance()
        var startRangeTime: Long? = null
        var endRangeTime: Long? = null

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
        val filterStart = DateFormatUtils.convertStartDate((if (filter == 3) startRangeTime else startDate.timeInMillis)!!)
        val filterEnd = DateFormatUtils.convertEndDate((if (filter == 3) endRangeTime!! else endDate.timeInMillis))
        val listItem = queryRekapProdukUseCase.invoke(filterStart, filterEnd, query)
        updateState(
            state.copy(
                itemList = listItem,
                start = filterStart,
                end = filterEnd
            )
        )
    }

    @SuppressLint("SuspiciousIndentation")
    fun cariItems(query: String, prclv: Int, filter: Int, selectFilter: String) = viewModelScope.launch {
        updateState(
            state.copy(
                searchQuery = query
            )
        )

        val startDate = Calendar.getInstance()
        val endDate = Calendar.getInstance()
        var startRangeTime: Long? = null
        var endRangeTime: Long? = null

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
        val newResult = loadCariItemsUseCase.invoke(state.searchQuery, prclv, DateFormatUtils.convertStartDate((if (filter == 3) startRangeTime else startDate.timeInMillis)!!),
          DateFormatUtils.convertEndDate((if (filter == 3) endRangeTime!! else endDate.timeInMillis)))
          updateState(
              state.copy(
                  itemListResult = newResult
              )
          )
    }

    fun filterItems(dataItem: List<Item>, filter: Int, selectFilter: String) = viewModelScope.launch {
        val itemListItm = mutableListOf<Item>()
        var mListSaled: List<Saled>? = null

        val startDate = Calendar.getInstance()
        val endDate = Calendar.getInstance()
        var startRangeTime: Long? = null
        var endRangeTime: Long? = null

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

        for (checkItem in dataItem){
            filterSearchItemUseCase.invoke(checkItem.id, DateFormatUtils.convertStartDate((if (filter == 3) startRangeTime else startDate.timeInMillis)!!),
                DateFormatUtils.convertEndDate((if (filter == 3) endRangeTime!! else endDate.timeInMillis))).collect{
                    mListSaled = it
            }
            for (data in mListSaled ?: mutableListOf()){
                checkItem.subtotal = data.subtotal
                checkItem.qty = data.qty
            }
            itemListItm.add(checkItem)
        }
        updateState(
            state.copy(
                resultFilteritem = itemListItm
            )
        )

    }

    fun getValuePid() = viewModelScope.launch {
        getPidByItemUseCase.invoke(state.item!!).collect{
            it.data?.let {
                updateState(
                    state.copy(
                        listPid = it
                    )
                )
            }
        }
    }

    fun showDialog() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDialogFilter)
    }

    sealed class UIEvent{
        object RequestDialogFilter: UIEvent()
    }
}