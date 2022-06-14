package com.bits.bee.bpmc.presentation.ui.home

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 14/06/22.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getActivePossesUseCase: GetActivePossesUseCase
) : BaseViewModel<HomeState, HomeViewModel.UIEvent>() {

    init {
        state = HomeState()
        getActivePosses()
    }

    private fun getActivePosses() = viewModelScope.launch {
        getActivePossesUseCase().collect {
            updateState(state.copy(activePosses = it))
        }
    }

    fun onPosClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPos)
    }

    sealed class UIEvent {
        object NavigateToPos : UIEvent()
    }

}