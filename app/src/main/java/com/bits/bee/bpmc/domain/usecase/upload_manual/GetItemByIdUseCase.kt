package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemByIdUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    operator fun invoke(id: Int): Flow<Item?>{
        return itemRepository.getItemById(id)
    }
}