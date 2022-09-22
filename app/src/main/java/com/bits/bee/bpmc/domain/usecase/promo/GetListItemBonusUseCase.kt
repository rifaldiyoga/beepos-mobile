package com.bits.bee.bpmc.domain.usecase.promo

import com.bits.bee.bpmc.domain.model.Promo
import com.bits.bee.bpmc.domain.model.PromoMulti
import com.bits.bee.bpmc.domain.repository.PromoMultiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/09/22
 */
class GetListItemBonusUseCase @Inject constructor(
    private val promoMultiRepository: PromoMultiRepository,
) {

    operator fun invoke(promo : Promo) : Flow<List<PromoMulti>> {
        return if(!promo.isDealSameItem)
            promoMultiRepository.getOfferPromoMultiByPromo(promo.id)
        else
            promoMultiRepository.getSyaratPromoMultiByPromo(promo.id)

    }

}