package com.bits.bee.bpmc.presentation.ui.sign_up.atur_produk

import com.bits.bee.bpmc.domain.usecase.signup.GetItemDummyUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by aldi on 31/08/22.
 */
@HiltViewModel
class AturProdukViewModel @Inject constructor(
    private val getItemDummyUseCase: GetItemDummyUseCase
) : BaseViewModel<AturProdukState, AturProdukViewModel.UIEvent>() {

    init {
        state = AturProdukState()
    }

    val itemDummyList = getItemDummyUseCase()

    sealed class UIEvent {

    }

}