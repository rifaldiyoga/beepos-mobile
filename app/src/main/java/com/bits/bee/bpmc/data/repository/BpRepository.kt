package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.source.local.dao.BpAddrDao
import com.bits.bee.bpmc.data.source.local.dao.BpDao
import com.bits.bee.bpmc.data.source.local.model.BpEntity
import com.bits.bee.bpmc.data.source.remote.ApiUtils
import com.bits.bee.bpmc.data.source.remote.response.BpResponse
import com.bits.bee.bpmc.domain.mapper.BpDataMapper
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class BpRepository @Inject constructor(
    private val apiUtils: ApiUtils,
    private val bpDao: BpDao,
    private val bpAddrDao : BpAddrDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    fun getLastesBpList(): Flow<Resource<List<Bp>>> {
        return object : NetworkDatabaseBoundResource<List<Bp>, BpResponse>(){
            override suspend fun loadFormDB(): List<Bp> {
                return bpDao.getBpList().map { BpDataMapper.fromDataToDomain(it) }
            }

            override fun shouldFetch(data: List<Bp>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<BpResponse>> {
                return apiUtils.getBpApiService().getBpList()
            }

            override suspend fun saveCallResult(data: BpResponse) {
                bpDao.insertSingle(data.data.toBp())
//                data.data.data.{
                    bpAddrDao.insertBulk(data.data.bpAddr.map { it.toBpAddr() })
//                }
            }
        }.getAsFlow()
    }

    fun getDefaultBp() : Flow<Resource<Bp>> {
        return flow {
            var data : BpEntity
            withContext(ioDispatcher){
                data = bpDao.getBpById(1)
            }
            emit(Resource.success(BpDataMapper.fromDataToDomain(data)))
        }
    }

    fun getFavoritBpList() : Flow<Resource<List<Bp>>> {
        return flow {
            var data : List<Bp>
            emit(Resource.loading())
            withContext(ioDispatcher){
                data = bpDao.getFavoritBpList(true).map { BpDataMapper.fromDataToDomain(it) }
            }
            emit(Resource.success(data))
        }
    }

}