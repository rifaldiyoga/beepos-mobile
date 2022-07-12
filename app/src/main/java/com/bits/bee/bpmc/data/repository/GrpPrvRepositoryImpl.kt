package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.GrpPrvDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.GrpPrvResponse
import com.bits.bee.bpmc.domain.mapper.GrpPrvDataMapper
import com.bits.bee.bpmc.domain.model.GrpPrv
import com.bits.bee.bpmc.domain.repository.GrpPrvRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class GrpPrvRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val grpPrvDao: GrpPrvDao,
    private val ioDispatcher: CoroutineDispatcher
) : GrpPrvRepository{

    override fun getLatestGrpPrvList(): Flow<Resource<List<GrpPrv>>> {
        return object : NetworkDatabaseBoundResource<List<GrpPrv>, GrpPrvResponse>(){
            override suspend fun loadFormDB(): List<GrpPrv> {
                return grpPrvDao.getGrpPrvList().map { GrpPrvDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<GrpPrv>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<GrpPrvResponse>> {
                return apiUtils.getGrpPrvApiService().getGrpPrv()
            }

            override suspend fun saveCallResult(data: GrpPrvResponse) {
                grpPrvDao.insertBulk(data.data.map { GrpPrvDataMapper.fromNetworkToData(it) })
            }
        }.getAsFlow()
    }
}