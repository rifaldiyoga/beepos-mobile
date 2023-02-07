package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.repository.KitchenRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestKitchenUseCase @Inject constructor(private val kitchenRepository: KitchenRepository) {

    operator fun invoke(): Flow<Resource<List<Kitchen>>> {
        return kitchenRepository.getLatestKitchen()
    }

}