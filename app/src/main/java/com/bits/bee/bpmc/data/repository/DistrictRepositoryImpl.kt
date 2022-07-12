package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.DistrictDao
import com.bits.bee.bpmc.data.data_source.local.model.DistrictEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.DistrictResponse
import com.bits.bee.bpmc.domain.mapper.DistrictDataMapper
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.domain.repository.DistrictRepository
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

class DistrictRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val districtDao: DistrictDao,
    private val defaultDispatcher: CoroutineDispatcher
): DistrictRepository {
    //    override fun getDitrictList(): Flow<Resource<List<District>>> {
//        return object : NetworkDatabaseBoundResource<List<District>, DistrictResponse>(){
//            override suspend fun loadFormDB(): List<District>? {
//                return districtDao.getDistrictList().map { it.toDistrict() }
//            }
//
//            override fun shouldFetch(data: List<District>?): Boolean {
//                return true
//            }
//
//            override suspend fun createCall(): Flow<ApiResponse<DistrictResponse>> {
//               return apiUtils.getDistrictApiService().getDistrictList()
//            }
//
//            override suspend fun saveCallResult(data: DistrictResponse) {
//                districtDao.insertBulk(data.data.data.map { DistrictDataMapper.fromResponseToData(it) })
//            }
//
//        }.getAsFlow()
//    }
    override suspend fun insertBulkDistrict(list: List<DistrictEntity>) {
        withContext(defaultDispatcher){
            districtDao.insertBulk(list)
        }
    }

    override fun getLatestDistrict(page: Int): Flow<Resource<DistrictResponse>> {
        return object : NetworkBoundResource<DistrictResponse>(){
            override fun createCall(): Flow<ApiResponse<DistrictResponse>> {
                return apiUtils.getDistrictApiService().getDistrictList(page)
            }

        }.getAsFlow()
    }

    override fun getListDistrictByCode(code: String): Flow<Resource<List<District>>> {
        return flow {
            val data = districtDao.getListDistrictByCode(code).map { DistrictDataMapper.fromDataToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(defaultDispatcher)
    }

    override fun getCodeByName(name: String): Flow<Resource<District>> {
        return flow {
            val data = districtDao.getCodeByName(name)
            emit(Resource.success(DistrictDataMapper.fromDataToDomain(data)))
        }.flowOn(defaultDispatcher)
    }

    override fun getNameByCode(code: String): Flow<Resource<District>> {
        return flow {
            val data = districtDao.getNameByCode(code)
            emit(Resource.success(DistrictDataMapper.fromDataToDomain(data)))
        }.flowOn(defaultDispatcher)
    }
}