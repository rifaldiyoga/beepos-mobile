package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemAddOnDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemAddOnResponse
import com.bits.bee.bpmc.domain.mapper.ItemAddOnDataMapper
import com.bits.bee.bpmc.domain.model.ItemAddOn
import com.bits.bee.bpmc.domain.repository.ItemAddOnRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class ItemAddOnRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val itemAddOnDao: ItemAddOnDao,
    private val ioDispatcher: CoroutineDispatcher
) : ItemAddOnRepository {

    override fun getLatestItemAddOn(): Flow<Resource<List<ItemAddOn>>> {
        return object : NetworkDatabaseBoundResource<List<ItemAddOn>, ItemAddOnResponse>(){
            override suspend fun loadFormDB(): List<ItemAddOn> {
                return itemAddOnDao.getItemAddOnList().map { ItemAddOnDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<ItemAddOn>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<ItemAddOnResponse>> {
                return apiUtils.getItemAddOnApiService().getItemAddOn()
            }

            override suspend fun saveCallResult(data: ItemAddOnResponse) {
                itemAddOnDao.insertBulk(data.itemAddOnModels.map { ItemAddOnDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }

    override fun getItemAddOnByItem(itemId: Int): Flow<ItemAddOn?>  = flow {
        val data = itemAddOnDao.getItemAddOnByItem(itemId)
        emit(data?.let { ItemAddOnDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

}