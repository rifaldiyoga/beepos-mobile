package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemKitchenDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemKitchenResponse
import com.bits.bee.bpmc.domain.mapper.ItemKitchenDataMapper
import com.bits.bee.bpmc.domain.mapper.PrinterDataMapper
import com.bits.bee.bpmc.domain.model.ItemKitchen
import com.bits.bee.bpmc.domain.repository.ItemKitchenRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class ItemKitchenRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val itemKitchenDao: ItemKitchenDao,
    private val apiUtils: ApiUtils
) : ItemKitchenRepository {

    override fun getLatestItemKitchen(): Flow<Resource<List<ItemKitchen>>> {
        return object : NetworkDatabaseBoundResource<List<ItemKitchen>, ItemKitchenResponse>() {
            override suspend fun loadFormDB(): List<ItemKitchen>? {
                return itemKitchenDao.getItemKitchen().map { ItemKitchenDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<ItemKitchen>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<ItemKitchenResponse>> {
                return apiUtils.getItemApiService().getItemKitchen()
            }

            override suspend fun saveCallResult(data: ItemKitchenResponse) {
                itemKitchenDao.insertBulk(data.data.map { ItemKitchenDataMapper.fromNetworkToDb(it) })
            }

        }.getAsFlow()
    }

    override fun getByPrinterKitchen(id: Int): Flow<List<ItemKitchen>> = flow {
        val data = itemKitchenDao.getItemKitchen()
        emit(data.map { ItemKitchenDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)


}