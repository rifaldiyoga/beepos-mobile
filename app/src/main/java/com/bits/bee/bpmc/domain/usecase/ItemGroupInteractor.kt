package com.bits.bee.bpmc.domain.usecase

import com.bits.bee.bpmc.data.repository.CityRepository
import com.bits.bee.bpmc.data.repository.ItemGroupRepository
import com.bits.bee.bpmc.data.source.local.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepositoryI
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemGroupInteractor @Inject constructor(private val itmgrpRepository: ItemGroupRepository): ItemGroupRepositoryI {
    override fun getItemGroupList(): Flow<Resource<List<ItemGroup>>> = itmgrpRepository.getItemGroupList()

}