package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ProvinceDao
import com.bits.bee.bpmc.data.data_source.local.model.ProvinceEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.BranchResponse
import com.bits.bee.bpmc.data.data_source.remote.response.ProvinceResponse
import com.bits.bee.bpmc.domain.mapper.ProvinceDataMapper
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Province
import com.bits.bee.bpmc.domain.repository.ProvinceRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProvinceRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val provinceDao: ProvinceDao,
    private val defaultDispatcher: CoroutineDispatcher
): ProvinceRepository {
    //    override fun getProvinceList(): Flow<Resource<List<Province>>> {
//        return object : NetworkDatabaseBoundResource<List<Province>, ProvinceResponse>(){
//            override suspend fun loadFormDB(): List<Province>? {
//                return provinceDao.getProvinceList().map { it.toProvince() }
//            }
//
//            override fun shouldFetch(data: List<Province>?): Boolean {
//                return true
//            }
//
//            override suspend fun createCall(): Flow<ApiResponse<ProvinceResponse>> {
//                return apiUtils.getProvinceApiService().getProvinceList()
//            }
//
//            override suspend fun saveCallResult(data: ProvinceResponse) {
//                provinceDao.insertBulk(data.data.data.map { ProvinceDataMapper.fromResponseToData(it) })
//            }
//
//        }.getAsFlow()
//    }
    override suspend fun insertBulkProvince(list: List<ProvinceEntity>) {
        withContext(defaultDispatcher){
            provinceDao.insertBulk(list)
        }
    }

    override fun getLatestProvince(page: Int): Flow<Resource<ProvinceResponse>> {
        return object : NetworkBoundResource<ProvinceResponse>(){
            override fun createCall(): Flow<ApiResponse<ProvinceResponse>> {
                return apiUtils.getProvinceApiService().getProvinceList(page)
            }

        }.getAsFlow()
    }
}