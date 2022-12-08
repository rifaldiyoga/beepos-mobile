package com.bits.bee.bpmc.presentation.dialog.pilih_kategori

import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemGroupUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by aldi on 29/11/22
 */
@HiltViewModel
class PilihKategoriViewModel @Inject constructor(
    private val getActiveItemGroupUseCase: GetActiveItemGroupUseCase
) : BaseViewModel<Any, PilihKategoriViewModel.UIEvent>() {

    val grpList = getActiveItemGroupUseCase()

    sealed class UIEvent {

    }

}