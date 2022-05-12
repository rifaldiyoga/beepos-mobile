package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemDao
import com.bits.bee.bpmc.data.data_source.local.dao.ItemGroupDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemGroupResponse
import com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse
import com.bits.bee.bpmc.domain.mapper.ItemGroupDataMapper
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class ItemRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val itemDao: ItemDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ItemRepository {

    override fun getLastesItemList(page: Int): Flow<Resource<ItemResponse>> {
        return object : NetworkDatabaseBoundResource<ItemResponse, ItemResponse>(){
            override suspend fun loadFormDB(): ItemResponse? {
                return null
            }

            override fun shouldFetch(data: ItemResponse?): Boolean {
                return false
            }

            override suspend fun createCall(): Flow<ApiResponse<ItemResponse>> {
                return apiUtils.getItemApiService().getItem()
            }

            override suspend fun saveCallResult(data: ItemResponse) {
//                itemDao.insertSingle()
            }

        }.getAsFlow()
    }

}