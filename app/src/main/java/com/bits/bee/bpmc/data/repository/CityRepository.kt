package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.source.local.dao.CityDao
import com.bits.bee.bpmc.data.source.local.model.City
import com.bits.bee.bpmc.data.source.remote.ApiUtils
import com.bits.bee.bpmc.data.source.remote.response.CityResponse
import com.bits.bee.bpmc.domain.repository.CityRepositoryI
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class CityRepository @Inject constructor(
    private val apiUtils: ApiUtils,
    private val cityDao: CityDao
) : CityRepositoryI {

    override fun getCityList(): Flow<Resource<List<City>>> {
        return object : NetworkDatabaseBoundResource<List<City>, CityResponse>(){
            override suspend fun loadFormDB(): List<City>? {
                return cityDao.getCityList()
            }

            override fun shouldFetch(data: List<City>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<CityResponse>> {
                return apiUtils.getCityApiService().getCityList()
            }

            override suspend fun saveCallResult(data: CityResponse) {
                cityDao.insertBulk(data.data.data.map { it.toCity() })
            }
        }.getAsFlow()
    }

    fun getCityDao(): List<City>{
        return cityDao.getCityName()
    }
}