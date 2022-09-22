package com.bits.bee.bpmc.presentation.ui.splash

import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager
) : BaseViewModel<SplashScreenState, SplashScreenViewModel.UIEvent>() {

    val posPreferences = beePreferenceManager.posPreferences

    fun onUpdateOrientation(orientation: String) = viewModelScope.launch {
        beePreferenceManager.updatePosPreferences(
            posPreferences.first().copy(
                orientasi = orientation
            )
        )
    }

    sealed class UIEvent {

    }

}