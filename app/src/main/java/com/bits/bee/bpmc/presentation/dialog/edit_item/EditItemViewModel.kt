package com.bits.bee.bpmc.presentation.dialog.edit_item

import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

/**
 * Created by aldi on 25/05/22.
 */
class EditItemViewModel : BaseViewModel<EditItemState, EditItemViewModel.UIEvent>() {

    sealed class UIEvent {

    }

}