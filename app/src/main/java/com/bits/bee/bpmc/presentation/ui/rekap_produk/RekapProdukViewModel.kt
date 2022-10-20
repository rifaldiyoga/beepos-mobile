package com.bits.bee.bpmc.presentation.ui.rekap_produk

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Item
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
    private val loadCariItemsUseCase: LoadCariItemsUseCase
): BaseViewModel<RekapProdukState, RekapProdukViewModel.UIEvent>() {

    private var querySearch=""

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
        val listItem = queryRekapProdukUseCase.invoke(DateFormatUtils.convertStartDate((if (filter == 3) startRangeTime else startDate.timeInMillis)!!),
            DateFormatUtils.convertEndDate((if (filter == 3) endRangeTime!! else endDate.timeInMillis)), query)
        updateState(
            state.copy(
                itemList = listItem
            )
        )
    }

    fun cariItems(query: String, prclv: Int) = viewModelScope.launch {
      val listItem = loadCariItemsUseCase.invoke(query, prclv)
        updateState(
            state.copy(
                itemList = listItem
            )
        )
    }

    fun showDialog() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestDialogFilter)
    }

    sealed class UIEvent{
        object RequestDialogFilter: UIEvent()
    }
}