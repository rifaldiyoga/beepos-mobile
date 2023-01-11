package com.bits.bee.bpmc.presentation.dialog.setoran_kasir

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.common.GetDefaultCrcUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 09/06/22.
 */
@HiltViewModel
class SetoranKasirViewModel @Inject constructor(
    private val getDefaultCrcUseCase: GetDefaultCrcUseCase
) : BaseViewModel<SetoranKasirState, SetoranKasirViewModel.UIEvent>(){

    init {
        state = SetoranKasirState()
    }

    fun onBukaKasirClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestSave)
    }

    fun saveBukaKasir() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestSave)
    }

    fun onDoneSave() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPos)
    }

    fun onInsight() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToInsight)
    }


    sealed class UIEvent {
        object NavigateToPos : UIEvent()
        object NavigateToDefaultModal : UIEvent()
        object NavigateToInsight : UIEvent()
        object RequestSave : UIEvent()
    }
}