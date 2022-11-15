package com.bits.bee.bpmc.domain.usecase.printer;

import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject;

class GetItemgrpIdUseCase @Inject constructor(
   private val itemGroupRepository: ItemGroupRepository
) {
   operator fun invoke(id: Int): Flow<ItemGroup> {
      return itemGroupRepository.getById(id)
   }
}
