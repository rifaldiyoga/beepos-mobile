package com.bits.bee.bpmc.presentation.ui.pos.promo

import com.bits.bee.bpmc.domain.usecase.printer.GetActivePromoUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by aldi on 19/08/22.
 */
@HiltViewModel
class PromoViewModel @Inject constructor(
    private val getActivePromoUseCase: GetActivePromoUseCase
): BaseViewModel<PromoState, PromoViewModel.UIEvent>(){

    val promoList = getActivePromoUseCase()

    sealed class UIEvent{

    }
}