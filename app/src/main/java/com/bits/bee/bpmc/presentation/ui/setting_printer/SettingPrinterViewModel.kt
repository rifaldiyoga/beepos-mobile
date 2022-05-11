package com.bits.bee.bpmc.presentation.ui.setting_printer

class SettingPrinterViewModel {
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingPrinterViewModel @Inject constructor(

): BaseViewModel<SettingPrinterState, SettingPrinterViewModel.UIEvent>() {

    fun onClickAddPrinter() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestAddPrinter)
    }

    sealed class UIEvent{
        object RequestAddPrinter: UIEvent()
    }
}