package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.source.local.model.ItemGroup
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
interface ItemGroupRepositoryI {

    fun getItemGroupList() : Flow<Resource<List<ItemGroup>>>

}