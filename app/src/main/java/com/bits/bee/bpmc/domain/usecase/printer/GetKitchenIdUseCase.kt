package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.KitchenEntity
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.repository.KitchenRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetKitchenIdUseCase @Inject constructor(
    private val kitchenRepository: KitchenRepository
) {
    operator fun invoke(id: Int): Flow<Resource<Kitchen>> {
        return kitchenRepository.getKitchenId(id)
    }
}