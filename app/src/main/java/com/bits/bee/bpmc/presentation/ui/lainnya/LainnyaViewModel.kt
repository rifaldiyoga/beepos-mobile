package com.bits.bee.bpmc.presentation.ui.lainnya

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by aldi on 07/06/22.
 */
class LainnyaViewModel : BaseViewModel<LainnyaState,LainnyaViewModel.UIEvent>() {


    fun onUploadManual() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToUploadManual)
    }

    fun onCekStok() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToCekStok)
    }

    fun onRekapKas() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToRekapKas)
    }

    fun onKelolaProduk() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToKelolaProduk)
    }

    fun onPengaturan() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPengaturan)
    }

    fun onRekapProduk() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToRekapProduk)
    }

    fun onDownload() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToDownload)
    }

    sealed class UIEvent {
        object NavigateToUploadManual : UIEvent()
        object NavigateToCekStok : UIEvent()
        object NavigateToRekapKas : UIEvent()
        object NavigateToRekapProduk : UIEvent()
        object NavigateToKelolaProduk : UIEvent()
        object NavigateToPengaturan : UIEvent()
        object NavigateToDownload : UIEvent()
    }

}