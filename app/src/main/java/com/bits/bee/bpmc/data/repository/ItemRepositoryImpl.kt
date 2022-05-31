package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemDao
import com.bits.bee.bpmc.data.data_source.local.dao.PriceDao
import com.bits.bee.bpmc.data.data_source.local.dao.UnitDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse
import com.bits.bee.bpmc.domain.mapper.ItemDataMapper
import com.bits.bee.bpmc.domain.mapper.PriceDataMapper
import com.bits.bee.bpmc.domain.mapper.UnitDataMapper
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class ItemRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val itemDao: ItemDao,
    private val priceDao: PriceDao,
    private val unitDao: UnitDao,
    private val defaultDispatcher : CoroutineDispatcher
) : ItemRepository {

    override fun getLastesItemList(page: Int): Flow<Resource<ItemResponse>> {
        return object : NetworkDatabaseBoundResource<ItemResponse, ItemResponse>(){
            override suspend fun loadFormDB(): ItemResponse? {
                return null
            }

            override fun shouldFetch(data: ItemResponse?): Boolean {
                return false
            }

            override suspend fun createCall(): Flow<ApiResponse<ItemResponse>> {
                return apiUtils.getItemApiService().getItem()
            }

            override suspend fun saveCallResult(data: ItemResponse) {
                itemDao.insertSingle(ItemDataMapper.fromDataToResponse(data.data.item))
                priceDao.deleteAll()
                priceDao.insertBulk(data.data.price.map { PriceDataMapper.fromDataToResponse(it) })
                unitDao.insertBulk(data.data.unit.map { UnitDataMapper.fromDataToResponse(it) })
            }

        }.getAsFlow()
    }

    override fun getActiveItemListByItemGrp(itemGrpId: Int): Flow<List<Item>> {
        return flow<List<Item>> {
            emit(itemDao.getActiveItemListByItemGrp(itemGrpId).map { ItemDataMapper.fromDataToDomain(it) })
        }.flowOn(defaultDispatcher)
    }

    override fun getActiveItemList(): Flow<List<Item>> = flow {
        emit(itemDao.getActiveItemList().map { ItemDataMapper.fromDataToDomain(it) })
    }.flowOn(defaultDispatcher)


}