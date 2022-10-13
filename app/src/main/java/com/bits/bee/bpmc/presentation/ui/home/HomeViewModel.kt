package com.bits.bee.bpmc.presentation.ui.home

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 14/06/22.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager
) : BaseViewModel<HomeState, HomeViewModel.UIEvent>() {

    private val _posModeState = MutableStateFlow(PosModeState.FnBState)
    @OptIn(FlowPreview::class)
    val posModeState : StateFlow<PosModeState> = _posModeState
        .filterNotNull()
        .flatMapConcat { beePreferenceManager.modePreferences }
        .stateIn(viewModelScope, SharingStarted.Lazily, PosModeState.FnBState)

    init {
        state = HomeState()
    }

    fun onPosClick() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPos)
    }

    sealed class UIEvent {
        object NavigateToPos : UIEvent()
    }

}