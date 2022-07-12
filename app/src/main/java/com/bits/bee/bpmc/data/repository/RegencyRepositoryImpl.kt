package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.RegencyDao
import com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.RegencyResponse
import com.bits.bee.bpmc.domain.mapper.CityDataMapper
import com.bits.bee.bpmc.domain.mapper.RegencyDataMapper
import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.domain.model.Regency
import com.bits.bee.bpmc.domain.repository.RegencyRepository
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

class RegencyRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val regencyDao: RegencyDao,
    private val defaultDispatcher: CoroutineDispatcher
): RegencyRepository {
    //    override fun getRegencyList(): Flow<Resource<List<Regency>>> {
//        return object : NetworkDatabaseBoundResource<List<Regency>, RegencyResponse>(){
//            override suspend fun loadFormDB(): List<Regency>? {
//                return regencyDao.getRegencyList().map { it.toRegency() }
//            }
//
//            override fun shouldFetch(data: List<Regency>?): Boolean {
//                return true
//            }
//
//            override suspend fun createCall(): Flow<ApiResponse<RegencyResponse>> {
//                return apiUtils.getRegencyApiService().getRegencyList()
//            }
//
//            override suspend fun saveCallResult(data: RegencyResponse) {
//                regencyDao.insertBulk(data.data.data.map { RegencyDataMapper.fromResponseToData(it) })
//            }
//
//        }.getAsFlow()
//    }
    override suspend fun insertBulkRegency(list: List<RegencyEntity>) {
        withContext(defaultDispatcher){
            regencyDao.insertBulk(list)
        }
    }

    override fun getLatestRegency(page: Int): Flow<Resource<RegencyResponse>> {
        return object : NetworkBoundResource<RegencyResponse>(){
            override fun createCall(): Flow<ApiResponse<RegencyResponse>> {
                return apiUtils.getRegencyApiService().getRegencyList(page)
            }

        }.getAsFlow()
    }

    override fun searchRegencyList(q: String): Flow<List<Regency>> {
        return flow {
                emit(regencyDao.searchRegencyList(q).map { RegencyDataMapper.fromDbToDomain(it) })
        }.flowOn(defaultDispatcher)
    }

    override fun getCodeByRegency(name: String): Flow<Resource<Regency>> {
        return flow {
            val data = regencyDao.getCodeByName(name)
            emit(Resource.success(RegencyDataMapper.fromDbToDomain(data)))
        }.flowOn(defaultDispatcher)
    }

    override fun getRegencyByCode(code: String): Flow<Resource<Regency>> {
        return flow {
            val data = regencyDao.getNameByCode(code)
            emit(Resource.success(RegencyDataMapper.fromDbToDomain(data)))
        }.flowOn(defaultDispatcher)
    }


}