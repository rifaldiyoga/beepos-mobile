package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.ItemVariant
import com.bits.bee.bpmc.domain.repository.ItemVariantRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestItemVariantUseCase @Inject constructor(private val itemVariantRepository: ItemVariantRepository) {

    operator fun invoke(): Flow<Resource<List<ItemVariant>>> {
        return itemVariantRepository.getLatestItemVariantList()
    }

}