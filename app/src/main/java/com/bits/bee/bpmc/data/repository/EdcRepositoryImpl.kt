package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.EdcDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.EdcResponse
import com.bits.bee.bpmc.domain.mapper.EdcDataMapper
import com.bits.bee.bpmc.domain.model.Edc
import com.bits.bee.bpmc.domain.repository.EdcRepository
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
class EdcRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val edcDao: EdcDao,
    private val defDisp : CoroutineDispatcher
) : EdcRepository {

    override fun getLatestEdc(): Flow<Resource<List<Edc>>> {
        return object : NetworkDatabaseBoundResource<List<Edc>, EdcResponse>(){
            override suspend fun loadFormDB(): List<Edc>? {
                return edcDao.getEdcList().map { EdcDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<Edc>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<EdcResponse>> {
                return apiUtils.getEdcApiService().getEdc()
            }

            override suspend fun saveCallResult(data: EdcResponse) {
                edcDao.deleteAll()
                edcDao.insertBulk(data.data.map { EdcDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }

    override fun getActiveEdcList(branchId : Int): Flow<List<Edc>> = flow {
        emit(edcDao.getActiveEdc(branchId).map { EdcDataMapper.fromDbToDomain(it) })
    }.flowOn(defDisp)

}