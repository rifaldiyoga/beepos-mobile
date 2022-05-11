package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PmtdDao
import com.bits.bee.bpmc.data.data_source.local.model.Pmtd
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.PmtdResponse
import com.bits.bee.bpmc.domain.repository.PmtdRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class PmtdRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val pmtdDao: PmtdDao
) : PmtdRepository {

     override fun getPmtdList(): Flow<Resource<List<Pmtd>>> {
        return object : NetworkDatabaseBoundResource<List<Pmtd>, PmtdResponse>(){
            override suspend fun loadFormDB(): List<Pmtd>? {
                return pmtdDao.getPmtdList()
            }

            override fun shouldFetch(data: List<Pmtd>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<PmtdResponse>> {
                return apiUtils.getPmtdApiService().getPmtdList()
            }

            override suspend fun saveCallResult(data: PmtdResponse) {
                pmtdDao.insertBulk(data.data.data.map { it.toPmtd() })
            }
        }.getAsFlow()
    }
}