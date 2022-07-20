package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.CrcDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.CrcResponse
import com.bits.bee.bpmc.domain.mapper.CrcDataMapper
import com.bits.bee.bpmc.domain.model.Crc
import com.bits.bee.bpmc.domain.repository.CrcRepository
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
class CrcRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val crcDao: CrcDao,
    private val apiUtils: ApiUtils
) : CrcRepository {

    override fun getLatestCrc(): Flow<Resource<List<Crc>>> {
        return object : NetworkDatabaseBoundResource<List<Crc>, CrcResponse>() {

            override suspend fun loadFormDB(): List<Crc>? {
                return crcDao.getCrcList().map { CrcDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<Crc>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<CrcResponse>> {
                return apiUtils.getCrcApiService().getCrcList()
            }

            override suspend fun saveCallResult(data: CrcResponse) {
                crcDao.insertBulk(data.data.map { CrcDataMapper.fromNetworkToDb(it) })
            }

        }.getAsFlow()
    }

    override fun getDefaultCrc(): Flow<Crc?> = flow {
        emit(crcDao.getDefaultCrc()?.let { CrcDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)

}