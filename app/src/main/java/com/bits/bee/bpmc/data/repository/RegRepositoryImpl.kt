package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.RegDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.RegResponse
import com.bits.bee.bpmc.domain.mapper.RegDataMapper
import com.bits.bee.bpmc.domain.model.Reg
import com.bits.bee.bpmc.domain.repository.RegRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class RegRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val regDao: RegDao,
    private val ioDispatcher: CoroutineDispatcher
) : RegRepository{

    override fun getLatestRegList(): Flow<Resource<List<Reg>>> {
        return object : NetworkDatabaseBoundResource<List<Reg>, RegResponse>(){
            override suspend fun loadFormDB(): List<Reg> {
                return regDao.getRegList().map { RegDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<Reg>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<RegResponse>> {
                return apiUtils.getRegApiService().getReg()
            }

            override suspend fun saveCallResult(data: RegResponse) {
                regDao.insertSingle(RegDataMapper.fromNetworkToDb(data.regModel))
            }
        }.getAsFlow()
    }

}