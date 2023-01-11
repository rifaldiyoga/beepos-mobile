package com.bits.bee.bpmc.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.bits.bee.bpmc.data.data_source.local.dao.ItemDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemImageResponse
import com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse
import com.bits.bee.bpmc.domain.mapper.ItemDataMapper
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.utils.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class ItemRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val itemDao: ItemDao,
    private val defaultDispatcher : CoroutineDispatcher
) : ItemRepository {

    override fun getLastesItemList(page: Int): Flow<Resource<List<Item>>> {
        return object : NetworkDatabaseBoundResource<List<Item>, ItemResponse>(){
            override suspend fun loadFormDB(): List<Item> {
                return itemDao.getItemList().map { ItemDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<Item>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<ItemResponse>> {
                return apiUtils.getItemApiService().getInitialItem(1)
            }

            override suspend fun saveCallResult(data: ItemResponse) {
                itemDao.insertBulk(data.data.item.map { ItemDataMapper.fromNetworkToDb(it) })
            }

        }.getAsFlow()
    }

    override fun getLastesImageItem(page: Int): Flow<Resource<List<Item>>> {
        return object : NetworkDatabaseBoundResource<List<Item>, ItemImageResponse>(){
            override suspend fun loadFormDB(): List<Item> {
                return itemDao.getItemList().map { ItemDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<Item>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<ItemImageResponse>> {
                return apiUtils.getItemApiService().getImageItem()
            }

            override suspend fun saveCallResult(data: ItemImageResponse) {
                data.data.forEach { data ->
                    val item = itemDao.getItemById(data.refId)
                    item?.let {
                        itemDao.update(item.copy(
                            bucket = data.bucket,
                            objKey = data.objkey,
                            tempUrl = data.objkey.replace('/', '_')
                        ))
                    }
                }
            }

        }.getAsFlow()
    }

    override suspend fun getActiveItemListPagedByItemGrp(itemGrpId: Int, query: String, usePid : Boolean): Flow<PagingData<Item>> {
        val pagingSource = {
            if(usePid)
                itemDao.getItemByItemGrpPagedListPid(itemGrpId, query)
            else
                itemDao.getItemByItemGrpPagedList(itemGrpId, query, false)
        }

        return Pager(
            config = PagingConfig(
                pageSize = BPMConstants.BPM_LIMIT_PAGINATION,
                maxSize = BPMConstants.BPM_MAX_PAGINATION,
                initialLoadSize = BPMConstants.BPM_LIMIT_PAGINATION,
                enablePlaceholders = true
            ),
            pagingSourceFactory = pagingSource
        ).flow.mapLatest {
            it.map { ItemDataMapper.fromDbToDomain(it) }
        }.flowOn(defaultDispatcher)
    }

    override suspend fun getActiveItemListPaged(query : String, usePid : Boolean): Flow<PagingData<Item>> = Pager(
        config = PagingConfig(
            pageSize = BPMConstants.BPM_LIMIT_PAGINATION,
            maxSize = BPMConstants.BPM_MAX_PAGINATION,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            if(!usePid)
                itemDao.getActiveItemPagedList(query, usePid)
            else
                itemDao.getActiveItemPagedListPid(query)
        }
    ).flow.mapLatest {
        it.map { ItemDataMapper.fromDbToDomain(it) }
    }.flowOn(defaultDispatcher)

    override suspend fun getFavoriteItemListPaged(query: String): Flow<PagingData<Item>> = Pager(
        config = PagingConfig(
            pageSize = BPMConstants.BPM_LIMIT_PAGINATION,
            maxSize = BPMConstants.BPM_MAX_PAGINATION,
            initialLoadSize = BPMConstants.BPM_LIMIT_PAGINATION,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            itemDao.getFavoriteItemPagedList(query)
        }
    ).flow.mapLatest {
        it.map { ItemDataMapper.fromDbToDomain(it) }
    }.flowOn(defaultDispatcher)

    override fun getItemBySelection(selectionId: Int): Flow<List<Item>> = flow{
        emit(itemDao.getItemBySelection(selectionId).map { ItemDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)

    override fun getItemByVariant(variantId: Int): Flow<List<Item>> = flow{
        emit(itemDao.getItemByVariant(variantId).map { ItemDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)

    override fun getItemById(id: Int): Flow<Item?> {
        return flow {
            val data = itemDao.getItemById(id)
            emit(data?.let { ItemDataMapper.fromDbToDomain(data) })
        }.flowOn(defaultDispatcher)
    }

    override fun getActiveItemList(): Flow<List<Item>> = flow {
        emit(itemDao.getActiveItemList().map { ItemDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)

    override fun getActiveItemListByItemGrp(itemGrpId: Int): Flow<List<Item>> = flow {
        emit(itemDao.getActiveItemListByItemGrp(itemGrpId).map { ItemDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)

    override fun getItemByPrinterKitchen(id: Int): Flow<List<Item>> = flow {
        emit(itemDao.getItemByPrinterKitchen(id).map { ItemDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)

    override suspend fun addUpdateItem(item: Item) {
        withContext(defaultDispatcher){
            itemDao.insertSingle(ItemDataMapper.fromDomainToDb(item))
        }
    }

    override fun cariItems(query: String): Flow<List<Item>> {
        return flow {
            val data = itemDao.cariItems(query).map { ItemDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

}