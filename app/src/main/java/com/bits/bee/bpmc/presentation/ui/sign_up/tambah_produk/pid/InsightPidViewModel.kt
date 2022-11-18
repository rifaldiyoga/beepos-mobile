package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.pid

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsightPidViewModel @Inject constructor(

): BaseViewModel<InsightPidState, InsightPidViewModel.UIEvent>() {

    init {
        state = InsightPidState()
    }

    fun onSubmit() = viewModelScope.launch {

    }

    sealed class UIEvent {
        object ToAddProduk : UIEvent()
    }
}