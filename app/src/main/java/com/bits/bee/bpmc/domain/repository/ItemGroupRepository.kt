package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
interface ItemGroupRepository {

    fun getLastesItemGroupList(page : Int): Flow<Resource<List<ItemGroup>>>

    fun getActiveItemGroupList() : Flow<Resource<List<ItemGroup>>>

}