package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.CityDao
import com.bits.bee.bpmc.data.data_source.local.model.CityEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.CityResponse
import com.bits.bee.bpmc.domain.mapper.CityDataMapper
import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.domain.repository.CityRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class CityRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val cityDao: CityDao,
    private val defaultDispatcher : CoroutineDispatcher
) : CityRepository {

     override fun getLatestCityList(): Flow<Resource<List<City>>> {
        return object : NetworkDatabaseBoundResource<List<City>, CityResponse>(){
            override suspend fun loadFormDB(): List<City>? {
                return cityDao.getCityList().map { CityDataMapper.fromDataToDomain(it) }
            }

            override fun shouldFetch(data: List<City>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<CityResponse>> {
                return apiUtils.getCityApiService().getCityList()
            }

            override suspend fun saveCallResult(data: CityResponse) {
                cityDao.insertBulk(data.data.map { CityDataMapper.fromRemoteToData(it) })
            }
        }.getAsFlow()
    }

    override fun getActiveCityList(): Flow<List<City>> {
        return flow {
            emit(cityDao.getActiveCityList().map { CityDataMapper.fromDataToDomain(it) })
        }.flowOn(defaultDispatcher)
    }

    override fun searchCityList(query: String): Flow<List<City>> {
        return flow<List<City>> {
            emit(cityDao.searchCityList(query).map { CityDataMapper.fromDataToDomain(it) })
        }.flowOn(defaultDispatcher)
    }

    override fun getCodeByName(str: String): Flow<Resource<City>> {
        return flow {
            val data = cityDao.getCodeByName(str)
            if (data != null){
                emit(Resource.success(CityDataMapper.fromDataToDomain(data)))
            }else{
                emit(Resource.error(null, "data kosng"))
            }
        }.flowOn(defaultDispatcher)
    }

    fun getCityDao(): List<String>{
        return cityDao.getCityName()
    }
}