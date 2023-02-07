package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.CcTypeDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.CcTypeResponse
import com.bits.bee.bpmc.domain.mapper.CcTypeDataMapper
import com.bits.bee.bpmc.domain.model.CcType
import com.bits.bee.bpmc.domain.repository.CcTypeRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class CcTypeRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val ccTypeDao: CcTypeDao,
    private val ioDispatcher: CoroutineDispatcher
) : CcTypeRepository {

    override fun getLatestCcTypeList(): Flow<Resource<List<CcType>>> {
        return object : NetworkDatabaseBoundResource<List<CcType>, CcTypeResponse>(){
            override suspend fun loadFormDB(): List<CcType> {
                return ccTypeDao.getCcTypeList().map { CcTypeDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<CcType>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<CcTypeResponse>> {
                return apiUtils.getCcTypeApiService().getCcType()
            }

            override suspend fun saveCallResult(data: CcTypeResponse) {
                ccTypeDao.insertBulk(data.data.map { CcTypeDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }
}