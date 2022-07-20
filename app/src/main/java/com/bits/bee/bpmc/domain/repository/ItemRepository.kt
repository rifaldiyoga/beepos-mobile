package com.bits.bee.bpmc.domain.repository

import androidx.paging.PagingData
import com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
interface ItemRepository {

    fun getLastesItemList(page : Int): Flow<Resource<List<Item>>>

    suspend fun getActiveItemListByItemGrp(itemGrpId : Int, query: String) : Flow<PagingData<Item>>

    suspend fun getActiveItemList(query : String, ) : Flow<PagingData<Item>>

}