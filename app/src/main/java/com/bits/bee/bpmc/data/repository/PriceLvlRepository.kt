package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.source.local.dao.PriceLvlDao
import com.bits.bee.bpmc.data.source.remote.ApiUtils
import com.bits.bee.bpmc.data.source.remote.response.PriceLvlResponse
import com.bits.bee.bpmc.domain.mapper.PriceLvlDataMapper
import com.bits.bee.bpmc.domain.model.PriceLvl
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 26/04/22.
 */
class PriceLvlRepository @Inject constructor(
    private val apiUtils: ApiUtils,
    private val priceLvlDao: PriceLvlDao
){

    fun getLatestPriceLvl() : Flow<Resource<List<PriceLvl>>> {
        return object : NetworkDatabaseBoundResource<List<PriceLvl>, PriceLvlResponse>(){
            override suspend fun loadFormDB(): List<PriceLvl>? {
                return priceLvlDao.getPriceLvl().map { PriceLvlDataMapper.fromDataToDomain(it) }
            }

            override fun shouldFetch(data: List<PriceLvl>?): Boolean {
                return true
            }

            override suspend fun createCall(): kotlinx.coroutines.flow.Flow<ApiResponse<PriceLvlResponse>> {
                return apiUtils.getPriceLvlApiService().getPriceLvl()
            }

            override suspend fun saveCallResult(data: PriceLvlResponse) {
                val data = data.data.data.map { PriceLvlDataMapper.fromResponseToData(it) }
                priceLvlDao.insertBulk(data)
            }
        }.getAsFlow()
    }

}