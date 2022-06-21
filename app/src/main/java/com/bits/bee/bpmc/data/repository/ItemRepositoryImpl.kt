package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.*
import com.bits.bee.bpmc.data.data_source.local.model.ItemEntity
import com.bits.bee.bpmc.data.data_source.local.model.PriceEntity
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
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class ItemRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val itemDao: ItemDao,
    private val itemGroupDao: ItemGroupDao,
    private val priceLvlDao: PriceLvlDao,
    private val priceDao: PriceDao,
    private val unitDao: UnitDao,
    private val defaultDispatcher : CoroutineDispatcher
) : ItemRepository {

    override fun getLastesItemList(page: Int): Flow<Resource<ItemResponse>> {
//        return object : NetworkDatabaseBoundResource<ItemResponse, ItemResponse>(){
//            override suspend fun loadFormDB(): ItemResponse? {
//                return null
//            }
//
//            override fun shouldFetch(data: ItemResponse?): Boolean {
//                return false
//            }
//
//            override suspend fun createCall(): Flow<ApiResponse<ItemResponse>> {
//                return apiUtils.getItemApiService().getItem()
//            }
//
//            override suspend fun saveCallResult(data: ItemResponse) {
//                itemDao.insertSingle(ItemDataMapper.fromDataToResponse(data.data.item))
//                priceDao.deleteAll()
//                priceDao.insertBulk(data.data.price.map { PriceDataMapper.fromDataToResponse(it) })
//                unitDao.insertBulk(data.data.unit.map { UnitDataMapper.fromDataToResponse(it) })
//            }
//
//        }.getAsFlow()
        return flow<Resource<ItemResponse>> {
            val itgrpList = itemGroupDao.getActiveItemGroupList().map { it.id }
            val priceLvlList = priceLvlDao.getActivePriceLvl().map { it.id }
            var itemList = mutableListOf<ItemEntity>()
            var priceList = mutableListOf<PriceEntity>()
            priceDao.deleteAll()
            itemDao.deleteAll()

            for (a in 1..100) {
                val item = ItemEntity(
                    id = a,
                    code = "ITEM$a",
                    name1= "Item $a",
                    brandId= 1,
                    itemTypeCode = "",
                    usePid = false,
                    uniquePid = false,
                    itemGrpId = itgrpList.random(),
                    isStock = true,
                    isSale = true,
                    unitdesc = "PCS",
                    note = "",
                    active = true,
                    saleUnit = 1,
                    stockUnit = 1,
                    isPos = true,
                )

                itemList.add(item)

                for(priceLvl in priceLvlList) {
                    val price = PriceEntity(
                        priceLvlId = priceLvl,
                        itemId = item.id,
                        price = BigDecimal((10000..999999).random()),
                        discExp = "",
                        crcId = 1
                    )
                    priceList.add(price)
                }

            }

            itemDao.insertBulk(itemList)
            priceDao.insertBulk(priceList)

            emit(Resource.success(ItemResponse(true, "", ItemResponse.Data())))

        }.flowOn(defaultDispatcher)
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