package com.bits.bee.bpmc.presentation.dialog.detail_member

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 27/04/22.
 */
@HiltViewModel
class DetailMemberViewModel @Inject constructor(

): BaseViewModel<DetailMemberState, DetailMemberViewModel.UIEvent>() {

    init {
        state = DetailMemberState()
    }

    fun setOnClickInfoTax() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestInfoTax)
    }

    fun setOnClickInfo() = viewModelScope.launch {
        _state.update {
            it!!.copy(
                isInfoLainnya = !state.isInfoLainnya
            )
        }
    }

    fun update(data: Bp) = viewModelScope.launch {
        _state.update {
            it!!.copy(
                bp = data
            )
        }
    }

    sealed class UIEvent {
        object RequestInfoTax : UIEvent()
    }

}