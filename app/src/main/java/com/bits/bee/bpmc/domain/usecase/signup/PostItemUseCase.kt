package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.data.data_source.remote.response.ItemDummyResponse
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.repository.ItemDummyRepository
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.repository.UnitRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 24/11/22
 */
class PostItemUseCase @Inject constructor(
    private val itemDummyRepository: ItemDummyRepository,
    private val itemGroupRepository: ItemGroupRepository,
    private val unitRepository: UnitRepository
){

    suspend operator fun invoke(itemDummy : ItemDummy) : Flow<Resource<ItemDummyResponse>>{
        itemDummy.itemGroup = itemGroupRepository.getById(itemDummy.itemGroupId).first().name
        itemDummy.unit = unitRepository.getUnitByItem(itemDummy.id!!).first().firstOrNull()?.unit ?: "PCS"
        return itemDummyRepository.postItemDummy(itemDummy)
    }

}