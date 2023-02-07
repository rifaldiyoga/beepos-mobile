package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestItemUseCase @Inject constructor(private val itemRepository: ItemRepository) {

    operator fun invoke(page : Int): Flow<Resource<List<Item>>> = itemRepository.getLastesItemList(page)

}