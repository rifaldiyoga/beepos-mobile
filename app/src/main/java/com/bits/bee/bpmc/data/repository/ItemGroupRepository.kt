package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.source.local.dao.ItemGroupDao
import com.bits.bee.bpmc.data.source.local.model.ItemGroup
import com.bits.bee.bpmc.data.source.remote.ApiUtils
import com.bits.bee.bpmc.data.source.remote.response.ItemGroupResponse
import com.bits.bee.bpmc.domain.repository.ItemGroupRepositoryI
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class ItemGroupRepository @Inject constructor(
    private val apiUtils: ApiUtils,
    private val itemGroupDao: ItemGroupDao
) : ItemGroupRepositoryI {

    override fun getItemGroupList(): Flow<Resource<List<ItemGroup>>> {
        return object : NetworkDatabaseBoundResource<List<ItemGroup>, ItemGroupResponse>(){
            override suspend fun loadFormDB(): List<ItemGroup>? {
                return itemGroupDao.getItemGroupList()
            }

            override fun shouldFetch(data: List<ItemGroup>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<ItemGroupResponse>> {
                return apiUtils.getItemGroupApiService().getItemGroupList()
            }

            override suspend fun saveCallResult(data: ItemGroupResponse) {
                itemGroupDao.insertBulk(data.data.data.map { it.toItemGroup() })
            }
        }.getAsFlow()
    }
}