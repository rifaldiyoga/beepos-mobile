package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.UnitDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.UnitResponse
import com.bits.bee.bpmc.domain.mapper.UnitDataMapper
import com.bits.bee.bpmc.domain.model.Unit
import com.bits.bee.bpmc.domain.repository.UnitRepository
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
class UnitRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val unitDao : UnitDao,
    private val defDispatcher: CoroutineDispatcher
) : UnitRepository {

    override fun getLatestUnitList(): Flow<Resource<List<Unit>>> {
        return object : NetworkDatabaseBoundResource<List<Unit>, UnitResponse>(){
            override suspend fun loadFormDB(): List<Unit>? {
                return unitDao.getUnitList().map { UnitDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<Unit>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<UnitResponse>> {
                return apiUtils.getUnitApiService().getUnit()
            }

            override suspend fun saveCallResult(data: UnitResponse) {
                unitDao.deleteAll()
                unitDao.insertBulk(data.data.map { UnitDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }

    override fun getUnitByItem(itemId: Int): Flow<List<Unit>> = flow{
        val data = unitDao.getUnitByItem(itemId)
        emit(data.map { UnitDataMapper.fromDbToDomain(it) })
    }.flowOn(defDispatcher)

    override fun getUnitById(id: Int): Flow<Unit?> = flow {
        val data = unitDao.getUnitById(id)
        emit(data?.let { UnitDataMapper.fromDbToDomain(it) })
    }.flowOn(defDispatcher)

}