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

    suspend fun getActiveItemListPagedByItemGrp(itemGrpId : Int, query: String, usePid: Boolean) : Flow<PagingData<Item>>

    suspend fun getActiveItemListPaged(query : String, usePid : Boolean) : Flow<PagingData<Item>>

    suspend fun getFavoriteItemListPaged(query : String) : Flow<PagingData<Item>>

    fun getItemBySelection(selectionId : Int) : Flow<List<Item>>

    fun getItemByVariant(variantId : Int) : Flow<List<Item>>

    fun getItemById(id: Int): Flow<Item?>

    fun getActiveItemList() : Flow<List<Item>>

    fun getActiveItemListByItemGrp(itemGrpId: Int) : Flow<List<Item>>

    suspend fun addUpdateItem(item : Item)

}