package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemGroupUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by aldi on 28/10/22
 */
@HiltViewModel
class GroupListViewModel @Inject constructor(
    private val getActiveItemGroupUseCase: GetActiveItemGroupUseCase
) : BaseViewModel<Any, GroupListViewModel.UIEvent>()  {

    val itemGroupList = getActiveItemGroupUseCase()

    sealed class UIEvent {

    }

}