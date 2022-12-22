package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.KitchenDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.KitchenResponse
import com.bits.bee.bpmc.domain.mapper.KitchenDataMapper
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.repository.KitchenRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class KitchenRepositoryImpl @Inject constructor(
    private val kitchenDao: KitchenDao,
    private val apiUtils: ApiUtils,
    private val ioDispatcher: CoroutineDispatcher
): KitchenRepository {

    override fun getLatestKitchen(): Flow<Resource<List<Kitchen>>> {
        return object : NetworkDatabaseBoundResource<List<Kitchen>, KitchenResponse>(){
            override suspend fun loadFormDB(): List<Kitchen> {
                return kitchenDao.read().map { KitchenDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<Kitchen>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<KitchenResponse>> {
                return apiUtils.getKitchenApiService().getKitchen()
            }

            override suspend fun saveCallResult(data: KitchenResponse) {
                kitchenDao.insertBulk(data.kitchenModels.map { KitchenDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }

    override fun getKitchenId(id: Int): Flow<Kitchen> {
        return flow {
            val data = kitchenDao.getByKitchenId(id)
            emit(KitchenDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override fun getLastKitchen(): Flow<Kitchen> {
        return flow {
            val data = kitchenDao.getLastKitchen()
            emit(KitchenDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override fun readKitchen(): Flow<MutableList<Kitchen>> {
        return flow {
            val data = kitchenDao.read().map { KitchenDataMapper.fromDbToDomain(it) }
            emit(data.toMutableList())
        }.flowOn(ioDispatcher)
    }
}