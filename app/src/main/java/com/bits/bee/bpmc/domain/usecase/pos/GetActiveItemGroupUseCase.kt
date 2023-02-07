package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 21/04/22.
 */

class GetActiveItemGroupUseCase @Inject constructor(
    private val itemGroupRepository: ItemGroupRepository
) {

    operator fun invoke(): Flow<List<ItemGroup>> {
        return itemGroupRepository.getActiveItemGroupList()
    }

}