package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.ItemSaleTax
import com.bits.bee.bpmc.domain.repository.ItemSaleTaxRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestItemSaleTaxUseCase @Inject constructor(private val channelRepository: ItemSaleTaxRepository) {

    operator fun invoke(): Flow<Resource<List<ItemSaleTax>>> {
        return channelRepository.getLatestItemSaleTax()
    }

}