package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Promo
import com.bits.bee.bpmc.domain.repository.PromoRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 26/04/22.
 */
class GetLatestPromoUseCase @Inject constructor(
    private val priceLvlRepository: PromoRepository
) {

    operator fun invoke() : Flow<Resource<List<Promo>>>{
        return priceLvlRepository.getLatestPromo()
    }

}