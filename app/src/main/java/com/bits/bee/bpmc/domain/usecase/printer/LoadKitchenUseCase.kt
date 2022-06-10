package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.Kitchen
import com.bits.bee.bpmc.domain.repository.KitchenRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadKitchenUseCase @Inject constructor(
    private val kitchenRepo: KitchenRepository
) {
    operator fun invoke(): Flow<Resource<MutableList<Kitchen>>>{
        return kitchenRepo.readKitchen()
    }
}