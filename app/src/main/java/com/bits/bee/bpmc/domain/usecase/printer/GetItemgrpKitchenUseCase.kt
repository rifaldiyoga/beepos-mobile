package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemgrpKitchenUseCase @Inject constructor(
    private val itemGrpRepo: ItemGroupRepository
) {
    operator fun invoke(): Flow<Resource<List<ItemGroup>>>{
        return itemGrpRepo.getItemgrpKitchen()
    }
}