package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemGroupDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemGroupResponse
import com.bits.bee.bpmc.domain.mapper.ItemGroupDataMapper
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class ItemGroupRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val itemGroupDao: ItemGroupDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ItemGroupRepository {

    override suspend fun insertBulkItemGroup(list: List<ItemGroupEntity>) = withContext(ioDispatcher){
        val list = itemGroupDao.insertBulk(list)
    }

    override fun getLastesItemGroupList(page : Int): Flow<Resource<List<ItemGroup>>> {
        return object : NetworkDatabaseBoundResource<List<ItemGroup>, ItemGroupResponse>() {
            override suspend fun loadFormDB(): List<ItemGroup> {
                return itemGroupDao.getItemGroupList().map { ItemGroupDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<ItemGroup>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<ItemGroupResponse>> {
                return apiUtils.getItemGroupApiService().getItemGroupList()
            }

            override suspend fun saveCallResult(data: ItemGroupResponse) {
                itemGroupDao.insertBulk(data.data.map { ItemGroupDataMapper.fromNetworkToDb(it) })
            }

        }.getAsFlow()
    }

    override fun getActiveItemGroupList() : Flow<List<ItemGroup>> = flow {
        emit(itemGroupDao.getActiveItemGroupList().map { ItemGroupDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getId(id: Int): Flow<Resource<ItemGroup>> {
        return flow {
            val data = itemGroupDao.getId(id)
            emit((Resource.success(ItemGroupDataMapper.fromDbToDomain(data))))
        }.flowOn(ioDispatcher)
    }

    override fun getItemgrpKitchen(): Flow<Resource<List<ItemGroup>>> {
        return flow {
            var data = mutableListOf<ItemGroup>()
            withContext(ioDispatcher){
                itemGroupDao.getItemgrpKitchen().map { ItemGroupDataMapper.fromDbToDomain(it) }.onEach {
                    data.add(it)
                }
            }
            if (data.isNotEmpty()){
                emit(Resource.success(data))
            }else{
                emit(Resource.error(null, "data kosong"))
            }            }
    }

    override fun getItemgrpAddOn(): Flow<ItemGroup?> = flow<ItemGroup?> {
        val data = itemGroupDao.getItgrpAddOn()
        emit(data?.let { ItemGroupDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

}