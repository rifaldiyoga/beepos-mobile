package com.bits.bee.bpmc.presentation.ui.pos.transaksi_berhasil

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.printer.helper.PrinterHelper
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 02/06/22.
 */
@HiltViewModel
class TransaksiBerhasilViewModel @Inject constructor(
    val printerHelper: PrinterHelper
) : BaseViewModel<TransaksiBerhasilState, TransaksiBerhasilViewModel.UIEvent>(){

    fun onTutupClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPos)
    }

    fun onReprintClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestPrint)
    }

    sealed class UIEvent {
        object NavigateToPos : UIEvent()
        object RequestPrint : UIEvent()
    }
}