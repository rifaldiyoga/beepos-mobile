package com.bits.bee.bpmc.presentation.dialog.detail_addon

import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

/**
 * Created by aldi on 12/12/22
 */
class DetailAddOnViewModel : BaseViewModel<DetailAddOnState, DetailAddOnViewModel.UIEvent>() {

    init {
        state = DetailAddOnState()
    }

    sealed class UIEvent {

    }

}