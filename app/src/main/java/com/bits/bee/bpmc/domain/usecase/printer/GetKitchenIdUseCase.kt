package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.Kitchen
import com.bits.bee.bpmc.domain.repository.KitchenRepository
import javax.inject.Inject

class GetKitchenIdUseCase @Inject constructor(
    private val kitchenRepository: KitchenRepository
) {
    operator fun invoke(id: Int): Kitchen{
        return kitchenRepository.getKitchenId(id)
    }
}