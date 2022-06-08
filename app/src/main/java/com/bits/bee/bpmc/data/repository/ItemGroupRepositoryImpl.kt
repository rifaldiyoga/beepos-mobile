package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemGroupDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemGroupResponse
import com.bits.bee.bpmc.domain.mapper.ItemGroupDataMapper
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkBoundResource
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
        itemGroupDao.insertBulk(list)
    }

    override fun getLastesItemGroupList(page : Int): Flow<Resource<ItemGroupResponse>> {
        return object : NetworkBoundResource<ItemGroupResponse>() {
            override fun createCall(): Flow<ApiResponse<ItemGroupResponse>> {
                return apiUtils.getItemGroupApiService().getItemGroupList(page)
            }
        }.getAsFlow()
    }

    override fun getActiveItemGroupList() : Flow<Resource<List<ItemGroup>>> {
        return flow {
            emit(Resource.loading())
            var data : MutableList<ItemGroup> = mutableListOf()
            data.add(ItemGroup(-1, "*", "All", 1, 1, true))
            withContext(ioDispatcher){
                itemGroupDao.getActiveItemGroupList().map { ItemGroupDataMapper.fromDataToDomain(it) }.onEach {
                    data.add(it)
                }
            }
            if(data.isNotEmpty()) {
                emit(Resource.success(data))
            } else {
                emit(Resource.error(null, "Data Kosong"))
            }
        }
    }

    override fun getId(id: Int): ItemGroup {
        return itemGroupDao.getId(id)
    }

}