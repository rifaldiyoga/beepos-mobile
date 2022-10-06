package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.StockDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.StockResponse
import com.bits.bee.bpmc.domain.mapper.StockDataMapper
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.domain.model.Wh
import com.bits.bee.bpmc.domain.repository.StockRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class StockRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val stockDao: StockDao,
) : StockRepository {

    private var mStockList: List<Stock> = mutableListOf()

    override fun getStockByItem(
        item: Item,
        wh: Wh
    ): Flow<Resource<List<Stock>>> {
        return object : NetworkDatabaseBoundResource<List<Stock>, StockResponse>(){
            override suspend fun loadFormDB(): List<Stock> {
                return stockDao.getStockByItemAndWh(item.id, wh.id).map { StockDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<Stock>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<StockResponse>> {
                return apiUtils.getStockApiService().getStockByItem(item.code, wh.code)
            }

            override suspend fun saveCallResult(data: StockResponse) {
                stockDao.deleteStockByItemAndWh(item.id, wh.id)
                stockDao.insertBulk(data.stockModels.map { StockDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }

    override fun getItemStock(wh_id: Int): Flow<Resource<List<Stock>>> {
        return object : NetworkDatabaseBoundResource<List<Stock>, StockResponse>(){
            override suspend fun loadFormDB(): List<Stock>? {
                return mStockList
            }

            override fun shouldFetch(data: List<Stock>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<StockResponse>> {
                return apiUtils.getStockApiService().getItemStock(wh_id)
            }

            override suspend fun saveCallResult(data: StockResponse) {
                val stockList =  data.stockModels.map { StockDataMapper.fromNetworkToDb(it) }
                val stock = stockList.map { StockDataMapper.fromDbToDomain(it) }
                mStockList = stock
            }

        }.getAsFlow()
    }


}