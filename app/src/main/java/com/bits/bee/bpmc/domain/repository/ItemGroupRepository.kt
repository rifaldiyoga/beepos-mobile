package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ItemGroupResponse
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
interface ItemGroupRepository {

    suspend fun insertBulkItemGroup(list : List<ItemGroupEntity>)

    fun getLastesItemGroupList(page : Int): Flow<Resource<ItemGroupResponse>>

    fun getActiveItemGroupList() : Flow<Resource<List<ItemGroup>>>

    fun getId(id: Int) : Flow<Resource<ItemGroup>>

}