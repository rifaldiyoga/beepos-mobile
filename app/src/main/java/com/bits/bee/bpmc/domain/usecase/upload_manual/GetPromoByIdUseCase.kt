package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.Promo
import com.bits.bee.bpmc.domain.repository.PromoRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPromoByIdUseCase @Inject constructor(
    private val promoRepository: PromoRepository
) {
    operator fun invoke(id: Int): Flow<Promo>{
        return promoRepository.getPromoById(id)
    }
}