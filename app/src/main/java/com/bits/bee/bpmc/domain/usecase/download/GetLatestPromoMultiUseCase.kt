package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.PromoMulti
import com.bits.bee.bpmc.domain.repository.PromoMultiRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 26/04/22.
 */
class GetLatestPromoMultiUseCase @Inject constructor(
    private val priceLvlRepository: PromoMultiRepository
) {

    operator fun invoke() : Flow<Resource<List<PromoMulti>>>{
        return priceLvlRepository.getLatestPromoMulti()
    }

}