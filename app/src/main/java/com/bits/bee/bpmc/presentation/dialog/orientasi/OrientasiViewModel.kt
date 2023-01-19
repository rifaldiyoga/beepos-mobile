package com.bits.bee.bpmc.presentation.dialog.orientasi

import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrientasiViewModel @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager
) : BaseViewModel<Any, OrientasiViewModel.UIEvent>(){

    val modePreferences = beePreferenceManager.modePreferences

    sealed class UIEvent {

    }

}