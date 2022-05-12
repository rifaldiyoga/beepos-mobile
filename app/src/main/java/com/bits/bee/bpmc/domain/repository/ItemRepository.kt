package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
interface ItemRepository {

    fun getLastesItemList(page : Int): Flow<Resource<ItemResponse>>

}