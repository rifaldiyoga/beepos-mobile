package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.EdcSurcDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.EdcSurcResponse
import com.bits.bee.bpmc.domain.mapper.CcTypeDataMapper
import com.bits.bee.bpmc.domain.mapper.EdcSurcDataMapper
import com.bits.bee.bpmc.domain.model.EdcSurc
import com.bits.bee.bpmc.domain.model.EdcSurcAndCcType
import com.bits.bee.bpmc.domain.repository.EdcSurcRepository
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
class EdcSurcRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val edcSurcDao : EdcSurcDao,
    private val defDispatcher : CoroutineDispatcher
) : EdcSurcRepository {

    override fun getLatestEdcSurc(): Flow<Resource<List<EdcSurc>>> {
        return object : NetworkDatabaseBoundResource<List<EdcSurc>, EdcSurcResponse>() {
            override suspend fun loadFormDB(): List<EdcSurc>? {
                return edcSurcDao.getEdcSurcList().map { EdcSurcDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<EdcSurc>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<EdcSurcResponse>> {
                return apiUtils.getEdcSurcApiService().getEdcSurcList()
            }

            override suspend fun saveCallResult(data: EdcSurcResponse) {
                edcSurcDao.insertBulk(data.data.map { EdcSurcDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }

    override fun getEdcSurcActive(edcId: Int, type : String): Flow<List<EdcSurcAndCcType>> = flow {
        emit(edcSurcDao.getActiveEdcSurc(edcId, type).map { EdcSurcAndCcType(EdcSurcDataMapper.fromDbToDomain(it.edcSurc), CcTypeDataMapper.fromDbToDomain(it.ccType)) })
    }.flowOn(defDispatcher)


}