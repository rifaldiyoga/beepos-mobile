package com.bits.bee.bpmc.presentation.ui.detail_menu_bantuan

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.setting_list.SettingListViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailMenuHelpViewModel @Inject constructor(

): BaseViewModel<DetailMenuHelpState, DetailMenuHelpViewModel.UIEvent>() {

    init {
        state = DetailMenuHelpState()
    }

    fun onClickLisensi() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSettingLisensi)
    }

    sealed class UIEvent{
        object NavigateToSettingLisensi : UIEvent()
    }
}