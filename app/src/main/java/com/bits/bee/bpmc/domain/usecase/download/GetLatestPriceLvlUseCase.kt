package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.data.repository.PriceLvlRepository
import com.bits.bee.bpmc.domain.model.PriceLvl
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 26/04/22.
 */
class GetLatestPriceLvlUseCase @Inject constructor(
    private val priceLvlRepository: PriceLvlRepository
) {

    operator fun invoke() : Flow<Resource<List<PriceLvl>>>{
        return priceLvlRepository.getLatestPriceLvl()
    }

}