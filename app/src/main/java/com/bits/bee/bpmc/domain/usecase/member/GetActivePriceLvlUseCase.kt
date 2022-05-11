package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.model.PriceLvl
import com.bits.bee.bpmc.domain.repository.PriceLvlRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 10/05/22.
 */
class GetActivePriceLvlUseCase @Inject constructor(
    private val priceLvlRepository: PriceLvlRepository
) {

    operator fun invoke() : Flow<List<PriceLvl>> {
        return priceLvlRepository.getActivePriceLvl()
    }

}