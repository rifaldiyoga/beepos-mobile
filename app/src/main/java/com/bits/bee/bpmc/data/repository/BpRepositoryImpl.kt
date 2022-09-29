package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.BpAddrDao
import com.bits.bee.bpmc.data.data_source.local.dao.BpDao
import com.bits.bee.bpmc.data.data_source.local.model.BpAddrEntity
import com.bits.bee.bpmc.data.data_source.local.model.BpEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.post.BpPost
import com.bits.bee.bpmc.data.data_source.remote.response.BpResponse
import com.bits.bee.bpmc.data.data_source.remote.response.BpReturn
import com.bits.bee.bpmc.domain.mapper.BpDataMapper
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class BpRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val bpDao: BpDao,
    private val bpAddrDao : BpAddrDao,
    private val ioDispatcher: CoroutineDispatcher
) : BpRepository{

    override fun getLastesBpList(): Flow<Resource<List<Bp>>> {
        return object : NetworkDatabaseBoundResource<List<Bp>, BpResponse>() {
            override suspend fun loadFormDB(): List<Bp> {
                return bpDao.getBpList().map { BpDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<Bp>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<BpResponse>> {
                return apiUtils.getBpApiService().getBpList()
            }

            override suspend fun saveCallResult(data: BpResponse) {
                bpDao.insertBulk(data.data.map{BpDataMapper.fromNetworkToDb(it)})
                val bpAddrList = data.data.map {
                    BpAddrEntity(
                        cityCode = it.city_code ?: "",
                        bpId = it.id,
                        address = it.address ?: "",
                        phone = it.phone ?: "",
                    )
                }
                bpAddrDao.insertBulk(bpAddrList)
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

    override fun getBpById(id: Int): Flow<Bp?> = flow<Bp?> {
        val bp = bpDao.getBpById(id)
        emit(bp?.let { BpDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getFavoritBpList() : Flow<List<Bp>> {
        return flow {
            val data: List<Bp> = bpDao.getFavoritBpList(false).map { BpDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override fun getlastId(): Flow<Resource<Bp>> {
        return flow {
            val data = bpDao.getLastId()
            emit(Resource.success(BpDataMapper.fromDbToDomain(data)))
        }.flowOn(ioDispatcher)
    }

    override fun searchBp(query: String): Flow<Resource<List<Bp>>> {
        return flow {
            emit(Resource.success(bpDao.searchBp(query).map { BpDataMapper.fromDbToDomain(it) }))
        }.flowOn(ioDispatcher)
    }

    override suspend fun addUpdateBp(bpEntity: BpEntity) : Long {
        var id : Long
        withContext(ioDispatcher){
            id = bpDao.insertSingle(bpEntity)
        }
        return id
    }

    override fun getBpByDate(startDate: Long, endDate: Long): Flow<Resource<List<Bp>>> {
        return flow {
            val data = bpDao.getBpByDate(startDate, endDate).map { BpDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(ioDispatcher)
    }

    override fun getBpHaventUploaded(): Flow<Resource<List<Bp>>> {
        return flow {
            val data = bpDao.getBpHaventUploaded().map { BpDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(ioDispatcher)
    }

    override fun uploadBpClient(bpPost: BpPost): Flow<Resource<BpReturn>> {
        return object : NetworkBoundResource<BpReturn>(){
            override fun createCall(): Flow<ApiResponse<BpReturn>> {
                return apiUtils.getBpApiService().postBpClient(bpPost)
            }
        }.getAsFlow()
    }

    override fun getBpByCode(code: String): Flow<Resource<Bp>> {
        return flow {
            val data : BpEntity? = bpDao.getBpByCode(code)
            data?.let {
                emit(Resource.success(BpDataMapper.fromDbToDomain(data)))
            } ?: run {
                emit(Resource.error(null, "Data Bp Kosong!", 1))
            }
        }.flowOn(ioDispatcher)
    }

    override suspend fun updateBp(bpEntity: BpEntity) {
        withContext(ioDispatcher){
            bpDao.update(bpEntity)
        }
    }

    override suspend fun deleteBp(bpEntity: BpEntity) {
        withContext(ioDispatcher){
            bpDao.delete(bpEntity)
        }
    }

}