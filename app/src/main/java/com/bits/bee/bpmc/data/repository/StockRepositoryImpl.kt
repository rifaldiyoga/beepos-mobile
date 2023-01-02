package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.CrcDao
import com.bits.bee.bpmc.data.data_source.local.dao.ItemDao
import com.bits.bee.bpmc.data.data_source.local.dao.PriceDao
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
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class StockRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val stockDao: StockDao,
    private val itemDao: ItemDao,
    private val priceDao: PriceDao,
    private val crcDao: CrcDao,
    private val iodispatcher: CoroutineDispatcher
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

    override fun getPidByItem(id: Int): Flow<List<Stock>> {
        return flow {
            val data = stockDao.getStockByItem(id).map { StockDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(iodispatcher)
    }


    override fun getItemStock(wh_id: Int, query : String, sortDesc : Boolean): Flow<Resource<List<Stock>>> {
        return object : NetworkDatabaseBoundResource<List<Stock>, StockResponse>(){
            override suspend fun loadFormDB(): List<Stock> {
                return if(query.isNotEmpty()) {
                    var stockList = stockDao.read().map { StockDataMapper.fromDbToDomain(it) }
                    stockList.forEach {
                        it.itemName = itemDao.getItemById(it.itemId)?.name1 ?: ""
                        val price = priceDao.getPriceByPriceLvlItem(1, it.itemId, 1)
                        it.harga = price?.price ?: BigDecimal.ZERO
                        it.symbol = price?.let { crcDao.getCrcById(it.crcId)?.symbol } ?: ""
                    }
                    stockList = stockList.filter { it.itemName.contains(query, ignoreCase = true) }
                    if (sortDesc) stockList.sortedByDescending { it.itemName } else stockList.sortedBy { it.itemName }
                } else {
                    mutableListOf()
                }
            }

            override fun shouldFetch(data: List<Stock>?): Boolean {
                return query.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<StockResponse>> {
                return apiUtils.getStockApiService().getItemStock(wh_id)
            }

            override suspend fun saveCallResult(data: StockResponse) {
                stockDao.deleteAll()
                val stockList =  data.stockModels.map { StockDataMapper.fromNetworkToDb(it) }
                stockDao.insertBulk(stockList)
            }

        }.getAsFlow()
    }


}