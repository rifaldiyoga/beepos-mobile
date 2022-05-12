package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.data.data_source.remote.response.ItemGroupResponse
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestItemUseCase @Inject constructor(private val itemGroupRepository: ItemGroupRepository) {

    operator fun invoke(page : Int): Flow<Resource<ItemGroupResponse>> = itemGroupRepository.getLastesItemGroupList(page)

}