package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PriceDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse
import com.bits.bee.bpmc.domain.mapper.PriceDataMapper
import com.bits.bee.bpmc.domain.model.Price
import com.bits.bee.bpmc.domain.repository.PriceRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 13/05/22.
 */
class PriceRepositoryImpl @Inject constructor(
    private val priceDao: PriceDao,
    private val apiUtils: ApiUtils,
    private val defDispatcher: CoroutineDispatcher
) : PriceRepository {

    override fun getLatesPrice(): Flow<Resource<List<Price>>> {
        return object : NetworkDatabaseBoundResource<List<Price>, PriceResponse>() {
            override suspend fun loadFormDB(): List<Price>? {
                return priceDao.getPriceList().map { PriceDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<Price>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<PriceResponse>> {
                return apiUtils.getPriceApiService().getPrice()
            }

            override suspend fun saveCallResult(data: PriceResponse) {
                priceDao.insertBulk(data.data.map { PriceDataMapper.fromNetworkToDb(it) })
            }

        }.getAsFlow()
    }

    override fun getPriceByPriceLvl(priceLvlId: Int, itemId : Int): Flow<Price?> = flow {
        val price = priceDao.getPriceByPriceLvlItem(priceLvlId, itemId)
        emit(price?.let { PriceDataMapper.fromDbToDomain(it) })
    }.flowOn(defDispatcher)

}