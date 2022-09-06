package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.repository.ItemDummyRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by aldi on 31/08/22.
 */
class GetItemDummyUseCase @Inject constructor(
    private val itemDummyRepository: ItemDummyRepository
) {

    operator fun invoke() : Flow<Resource<List<ItemDummy>>> = itemDummyRepository.getItemDummyList()

}