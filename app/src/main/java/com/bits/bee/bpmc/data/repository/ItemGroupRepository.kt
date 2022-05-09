package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.source.local.dao.ItemGroupDao
import com.bits.bee.bpmc.data.source.local.model.ItemGroupEntity
import com.bits.bee.bpmc.data.source.remote.ApiUtils
import com.bits.bee.bpmc.data.source.remote.response.ItemGroupResponse
import com.bits.bee.bpmc.domain.mapper.ChannelDataMapper
import com.bits.bee.bpmc.domain.mapper.ItemGroupDataMapper
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class ItemGroupRepository @Inject constructor(
    private val apiUtils: ApiUtils,
    private val itemGroupDao: ItemGroupDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    fun getLastesItemGroupList(page : Int): Flow<Resource<List<ItemGroup>>> {
        return object : NetworkDatabaseBoundResource<List<ItemGroup>, ItemGroupResponse>(){
            override suspend fun loadFormDB(): List<ItemGroup>? {
                return itemGroupDao.getItemGroupList().map { ItemGroupDataMapper.fromDataToDomain(it) }
            }

            override fun shouldFetch(data: List<ItemGroup>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<ItemGroupResponse>> {
                return apiUtils.getItemGroupApiService().getItemGroupList(page)
            }

            override suspend fun saveCallResult(data: ItemGroupResponse) {
                itemGroupDao.insertBulk(data.data!!.data.map { it.toItemGroup() })
            }
        }.getAsFlow()
    }

    fun getItemGroupList() : Flow<Resource<List<ItemGroup>>> {
        return flow {

        }
    }

    fun getActiveItemGroupList() : Flow<Resource<List<ItemGroup>>> {
        return flow {
            emit(Resource.loading())
            var data : List<ItemGroup> = mutableListOf()
            withContext(ioDispatcher){
                data = itemGroupDao.getActiveItemGroupList().map { ItemGroupDataMapper.fromDataToDomain(it) }
            }
            if(data.isNotEmpty()) {
                emit(Resource.success(data))
            } else {
                emit(Resource.error(null, "Data Kosong"))
            }
        }
    }

}