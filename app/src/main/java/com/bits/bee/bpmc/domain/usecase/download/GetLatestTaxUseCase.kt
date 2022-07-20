package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.ItemSaleTax
import com.bits.bee.bpmc.domain.model.Tax
import com.bits.bee.bpmc.domain.repository.TaxRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestTaxUseCase @Inject constructor(private val channelRepository: TaxRepository) {

    operator fun invoke(): Flow<Resource<List<Tax>>> {
        return channelRepository.getLatestTaxList()
    }

}