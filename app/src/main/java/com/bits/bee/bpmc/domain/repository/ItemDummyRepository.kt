package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.remote.response.ItemDummyResponse
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface ItemDummyRepository {

    fun getItemDummyList() : Flow<List<ItemDummy>>

    suspend fun addItemDummy(itemDummy: ItemDummy) : Flow<Long>

    fun postItemDummy(itemDummy : ItemDummy) : Flow<Resource<ItemDummyResponse>>

    fun getLastId(): Flow<ItemDummy>

    suspend fun deleteItemDummy(itemDummy: ItemDummy)

}