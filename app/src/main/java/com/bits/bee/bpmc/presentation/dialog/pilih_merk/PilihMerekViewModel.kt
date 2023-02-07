package com.bits.bee.bpmc.presentation.dialog.pilih_merk

import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemGroupUseCase
import com.bits.bee.bpmc.domain.usecase.signup.GetMerekProdukUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by aldi on 29/11/22
 */
@HiltViewModel
class PilihMerekViewModel @Inject constructor(
    private val getMerekProdukUseCase: GetMerekProdukUseCase
) : BaseViewModel<Any, PilihMerekViewModel.UIEvent>() {

    val grpList = getMerekProdukUseCase()

    sealed class UIEvent {

    }

}