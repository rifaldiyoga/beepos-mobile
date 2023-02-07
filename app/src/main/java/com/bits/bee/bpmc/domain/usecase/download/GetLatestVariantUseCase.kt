package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Variant
import com.bits.bee.bpmc.domain.repository.VariantRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestVariantUseCase @Inject constructor(private val variantRepository: VariantRepository) {

    operator fun invoke(): Flow<Resource<List<Variant>>> {
        return variantRepository.getLatestVariantList()
    }

}