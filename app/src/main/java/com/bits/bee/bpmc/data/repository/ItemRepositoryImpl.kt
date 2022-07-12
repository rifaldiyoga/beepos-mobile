package com.bits.bee.bpmc.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.bits.bee.bpmc.BuildConfig
import com.bits.bee.bpmc.data.data_source.local.dao.*
import com.bits.bee.bpmc.data.data_source.local.model.ItemEntity
import com.bits.bee.bpmc.data.data_source.local.model.ItemSaleTaxEntity
import com.bits.bee.bpmc.data.data_source.local.model.PriceEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse
import com.bits.bee.bpmc.domain.mapper.ItemDataMapper
import com.bits.bee.bpmc.domain.mapper.PriceDataMapper
import com.bits.bee.bpmc.domain.mapper.UnitDataMapper
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class ItemRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val itemDao: ItemDao,
    private val itemSaleTaxDao: ItemSaleTaxDao,
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

            for (a in 1..500) {
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


                val itemSaleTaxEntity = ItemSaleTaxEntity(
                    code = "PPN",
                    calcMtd = "N",
                    expr = "11%",
                    exprNoReg = "11%"
                )
            }

            itemDao.insertBulk(itemList)
            priceDao.insertBulk(priceList)

            emit(Resource.success(ItemResponse(true, "", ItemResponse.Data())))

        }.flowOn(defaultDispatcher)
    }

    override fun getActiveItemListByItemGrp(itemGrpId: Int): Flow<List<Item>> {
        return flow<List<Item>> {
//            emit(itemDao.getActiveItemListByItemGrp(itemGrpId).map { ItemDataMapper.fromDbToDomain(it) })
        }.flowOn(defaultDispatcher)
    }

    override fun getActiveItemList(query : String): Flow<PagingData<Item>> = Pager(
        config = PagingConfig(
            pageSize = BPMConstants.BPM_LIMIT_PAGINATION,
            maxSize = BPMConstants.BPM_MAX_PAGINATION,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            itemDao.getActiveItemList(query)
        }
    ).flow.mapLatest {
        it.map { ItemDataMapper.fromDbToDomain(it) }
    }.flowOn(defaultDispatcher)

}