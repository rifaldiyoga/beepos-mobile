package com.bits.bee.bpmc.presentation.ui.upload_manual

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.manual_upload.GetDataSyncUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UploadManualViewModel @Inject constructor(
    private val getDataSyncUseCase: GetDataSyncUseCase,
): BaseViewModel<UploadManualState, UploadManualViewModel.UIEvent>() {

    init {
        state = UploadManualState()
    }

    val syncList = getDataSyncUseCase()

    fun onClickUpload() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestUpload)
    }

    fun showDialogNoInternet() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequeatDialog)
    }

    sealed class UIEvent {
        object RequestUpload : UIEvent()
        object RequeatDialog : UIEvent()
    }
}