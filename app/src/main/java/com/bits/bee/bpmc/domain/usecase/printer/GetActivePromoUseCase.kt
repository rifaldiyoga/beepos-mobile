package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.model.Promo
import com.bits.bee.bpmc.domain.repository.PromoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 19/08/22.
 */
class GetActivePromoUseCase @Inject constructor(
    private val promoRepository: PromoRepository
){

    operator fun invoke() : Flow<List<Promo>> = promoRepository.getActivePromoList()

}