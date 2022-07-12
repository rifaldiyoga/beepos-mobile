package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.BpAddrDao
import com.bits.bee.bpmc.data.data_source.local.dao.BpDao
import com.bits.bee.bpmc.data.data_source.local.model.BpEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.BpResponse
import com.bits.bee.bpmc.domain.mapper.BpDataMapper
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class CadjRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val bpDao: BpDao,
    private val bpAddrDao : BpAddrDao,
    private val ioDispatcher: CoroutineDispatcher
) : BpRepository{
    override fun getLastesBpList(): Flow<Resource<List<Bp>>> {
        return object : NetworkDatabaseBoundResource<List<Bp>, BpResponse>(){
            override suspend fun loadFormDB(): List<Bp> {
                return bpDao.getBpList().map { BpDataMapper.fromDbToDomain(it)!! }
            }

            override fun shouldFetch(data: List<Bp>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<BpResponse>> {
                return apiUtils.getBpApiService().getBpList()
            }

            override suspend fun saveCallResult(data: BpResponse) {
                bpDao.insertSingle(BpDataMapper.fromNetworkToData(data.data))
//                data.data.data.{
//                bpAddrDao.insertBulk(data.data.bpAddr.map { it.toBpAddr() })
//                }
            }
        }.getAsFlow()
    }

    override fun getDefaultBp() : Flow<Resource<Bp>> {
        return flow {
            val data : BpEntity? = bpDao.getBpById(1)
            data?.let {
                emit(Resource.success(BpDataMapper.fromDbToDomain(data)))
            } ?: run {
                emit(Resource.error(null, "Data Bp Kosong!", 1))
            }
        }.flowOn(ioDispatcher)
    }

    override fun getFavoritBpList() : Flow<Resource<List<Bp>>> {
        return flow {
            emit(Resource.loading())
            val data: List<Bp> = bpDao.getFavoritBpList(false).map { BpDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(ioDispatcher)
    }

    override suspend fun addUpdateBp(bpEntity: BpEntity){
        withContext(ioDispatcher){
            bpDao.insertSingle(bpEntity)
        }
    }

}