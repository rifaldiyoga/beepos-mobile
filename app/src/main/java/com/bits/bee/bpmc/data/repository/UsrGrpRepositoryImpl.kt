package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.UsrGrpDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.UsrGrpResponse
import com.bits.bee.bpmc.domain.mapper.UsrGrpDataMapper
import com.bits.bee.bpmc.domain.model.UsrGrp
import com.bits.bee.bpmc.domain.repository.UsrGrpRepository
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
class UsrGrpRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val usrGrpDao: UsrGrpDao,
    private val defDispatcher: CoroutineDispatcher
) : UsrGrpRepository {

    override fun getLatestUsrGrpList(): Flow<Resource<List<UsrGrp>>> {
        return object : NetworkDatabaseBoundResource<List<UsrGrp>, UsrGrpResponse>(){
            override suspend fun loadFormDB(): List<UsrGrp>? {
                return usrGrpDao.getUsrGrpList().map { UsrGrpDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<UsrGrp>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<UsrGrpResponse>> {
                return apiUtils.getUsrGrpApiService().getUsrGrp()
            }

            override suspend fun saveCallResult(data: UsrGrpResponse) {
                usrGrpDao.deleteAll()
                usrGrpDao.insertBulk(data.data.map { UsrGrpDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }

    override fun getByUsrId(id: Int): Flow<UsrGrp?> = flow {
        val data = usrGrpDao.getByUsrId(id)
        emit(data?.let { UsrGrpDataMapper.fromDbToDomain(data) })
    }.flowOn(defDispatcher)

}