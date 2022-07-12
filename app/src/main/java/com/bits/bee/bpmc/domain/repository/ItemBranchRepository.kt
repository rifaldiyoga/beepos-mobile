package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.ItemBranch
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface ItemBranchRepository {

    fun getLatestItemBranchList() : Flow<Resource<List<ItemBranch>>>

}