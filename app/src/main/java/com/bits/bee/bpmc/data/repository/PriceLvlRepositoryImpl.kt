package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PriceLvlDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.PriceLvlResponse
import com.bits.bee.bpmc.domain.mapper.PriceLvlDataMapper
import com.bits.bee.bpmc.domain.model.PriceLvl
import com.bits.bee.bpmc.domain.repository.PriceLvlRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 26/04/22.
 */
class PriceLvlRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val priceLvlDao: PriceLvlDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : PriceLvlRepository {

    override fun getLatestPriceLvl() : Flow<Resource<List<PriceLvl>>> {
        return object : NetworkDatabaseBoundResource<List<PriceLvl>, PriceLvlResponse>(){
            override suspend fun loadFormDB(): List<PriceLvl>? {
                return priceLvlDao.getActivePriceLvl().map { PriceLvlDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<PriceLvl>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<PriceLvlResponse>> {
                return apiUtils.getPriceLvlApiService().getPriceLvl()
            }

            override suspend fun saveCallResult(data: PriceLvlResponse) {
                val data = data.data.map { PriceLvlDataMapper.fromNetworkToDb(it) }
                priceLvlDao.insertBulk(data)
            }
        }.getAsFlow()
    }

    override fun getActivePriceLvl(): Flow<List<PriceLvl>> = flow {
        emit(priceLvlDao.getActivePriceLvl().map { PriceLvlDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

}