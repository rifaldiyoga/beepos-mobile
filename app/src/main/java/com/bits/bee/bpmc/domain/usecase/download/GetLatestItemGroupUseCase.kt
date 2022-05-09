package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.data.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepositoryI
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestItemGroupUseCase @Inject constructor(private val itemGroupRepository: ItemGroupRepository) : ItemGroupRepositoryI {

    override fun getItemGroupList(page : Int): Flow<Resource<List<ItemGroup>>> = itemGroupRepository.getLastesItemGroupList(page)

}