package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.ItemBranch
import com.bits.bee.bpmc.domain.repository.ItemBranchRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestItemBranchUseCase @Inject constructor(private val channelRepository: ItemBranchRepository) {

    operator fun invoke(): Flow<Resource<List<ItemBranch>>> {
        return channelRepository.getLatestItemBranchList()
    }

}