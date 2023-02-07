package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.repository.ItemRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CheckItemGroupAddOnUseCase @Inject constructor(
    private val itemGroupRepository: ItemGroupRepository,
    private val itemRepository: ItemRepository
){

    suspend operator fun invoke() {
        val itemGrp = itemGroupRepository.getItemgrpAddOn().first()
        if(itemGrp == null)
            itemRepository.updateIsVariant()
    }

}