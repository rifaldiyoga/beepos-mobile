package com.bits.bee.bpmc.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
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
import com.bits.bee.bpmc.utils.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest
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

    override fun getActiveBpPagedList(query : String, isFavorit : Boolean) : Flow<PagingData<Bp>> {
        val pagingSource = {
            if(isFavorit)
                bpDao.getFavoritBpPagedList(query, true)
            else
                bpDao.getBpPagedList(query)
        }

        return Pager(
            config = PagingConfig(
                pageSize = BPMConstants.BPM_LIMIT_PAGINATION,
                maxSize = BPMConstants.BPM_MAX_PAGINATION,
                enablePlaceholders = true
            ),
            pagingSourceFactory = pagingSource
        ).flow.mapLatest {
            it.map { BpDataMapper.fromDbToDomain(it) }
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

    override suspend fun addUpdateBp(bpEntity: Bp) : Long {
        var id : Long
        withContext(ioDispatcher){
            if(bpEntity.id == null)
                id = bpDao.insertSingle(BpDataMapper.fromDomainToDb(bpEntity))
            else {
                bpDao.update(BpDataMapper.fromDomainToDb(bpEntity))
                id = bpEntity.id!!.toLong()
            }
        }
        return id
    }

    override fun getBpByDate(startDate: Long, endDate: Long): Flow<Resource<List<Bp>>> {
        return flow {
            val data = bpDao.getBpByDate(startDate, endDate).map { BpDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(ioDispatcher)
    }

    override fun getBpHaventUploaded(): Flow<List<Bp>> {
        return flow {
            val data = bpDao.getBpHaventUploaded().map { BpDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override fun uploadBpClient(bpPost: BpPost): Flow<Resource<BpReturn>> {
        return object : NetworkBoundResource<BpReturn>(){
            override fun createCall(): Flow<ApiResponse<BpReturn>> {
                return apiUtils.getBpApiService().postBpClient(bpPost)
            }
        }.getAsFlow()
    }

    override fun getBpByCode(code: String): Flow<Bp?> {
        return flow {
            val data : BpEntity? = bpDao.getBpByCode(code)

            emit(data?.let { BpDataMapper.fromDbToDomain(data) })
        }.flowOn(ioDispatcher)
    }

    override suspend fun updateBp(bpEntity: Bp) {
        withContext(ioDispatcher){
            bpDao.update(BpDataMapper.fromDomainToDb(bpEntity))
        }
    }

    override suspend fun deleteBp(bpEntity: Bp) {
        withContext(ioDispatcher){
            bpDao.delete(BpDataMapper.fromDomainToDb(bpEntity))
        }
    }

    override suspend fun resetSelectedBp() = withContext(ioDispatcher) {
        bpDao.resetSelected()
    }

}