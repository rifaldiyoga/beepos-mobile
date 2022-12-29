package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.KitchenRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestImageItemUseCase @Inject constructor(private val itemRepository: ItemRepository) {

    operator fun invoke(): Flow<Resource<List<Item>>> {
        return itemRepository.getLastesImageItem(1)
    }

}