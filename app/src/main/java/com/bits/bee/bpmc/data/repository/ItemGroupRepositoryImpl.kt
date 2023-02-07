package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemGroupDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemGroupResponse
import com.bits.bee.bpmc.domain.mapper.ItemGroupDataMapper
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class ItemGroupRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val itemGroupDao: ItemGroupDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ItemGroupRepository {

    override suspend fun insertBulkItemGroup(list: List<ItemGroupEntity>) = withContext(ioDispatcher){
        val list = itemGroupDao.insertBulk(list)
    }

    override fun getLastesItemGroupList(page : Int): Flow<Resource<List<ItemGroup>>> {
        return object : NetworkDatabaseBoundResource<List<ItemGroup>, ItemGroupResponse>() {
            override suspend fun loadFormDB(): List<ItemGroup> {
                return itemGroupDao.getItemGroupList().map { ItemGroupDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<ItemGroup>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<ItemGroupResponse>> {
                return apiUtils.getItemGroupApiService().getItemGroupList()
            }

            override suspend fun saveCallResult(data: ItemGroupResponse) {
                itemGroupDao.insertSingle(
                    ItemGroupEntity(
                        id = -1,
                        code = "FAVORIT",
                        name = "Favorit",
                        level = 1,
                        upId = 1,
                        isPos = true
                    )
                )
                itemGroupDao.insertBulk(data.data.map { ItemGroupDataMapper.fromNetworkToDb(it) })
            }

        }.getAsFlow()
    }

    override fun getActiveItemGroupList() : Flow<List<ItemGroup>> = flow {
        emit(itemGroupDao.getActiveItemGroupList().map { ItemGroupDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getActiveItemGroupNotAddOnList(): Flow<List<ItemGroup>> = flow {
        emit(itemGroupDao.getItgrpNotAddon(true).map { ItemGroupDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getById(id: Int): Flow<ItemGroup>{
        return flow {
            val data = itemGroupDao.getId(id)
            emit(ItemGroupDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override fun getItemgrpAddOn(): Flow<ItemGroup?> = flow<ItemGroup?> {
        val data = itemGroupDao.getItgrpAddOn()
        emit(data?.let { ItemGroupDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getItemgrps(): Flow<List<ItemGroup>> {
        return flow {
            val data = itemGroupDao.getItemGroupList().map { ItemGroupDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override suspend fun addItemgrp(itemGroup: ItemGroup, edit: Boolean) {
        withContext(ioDispatcher){
            if (edit){
                itemGroupDao.update(ItemGroupDataMapper.fromDomainToDb(itemGroup))
            }else{
                itemGroupDao.insertSingle(ItemGroupDataMapper.fromDomainToDb(itemGroup))
            }
        }
    }

    override fun getItgrpByKategori(kategori: String): Flow<ItemGroup> {
        return flow<ItemGroup> {
            val data = itemGroupDao.getItgrpByKategori(kategori)
            emit(ItemGroupDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override fun getItemgrpParent(): Flow<List<ItemGroup>> {
        return flow {
            val data = itemGroupDao.getItemgrpParent().map { ItemGroupDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override fun getItemgrpByUpId(upid: Int?): Flow<List<ItemGroup>> {
        return flow {
            val data = itemGroupDao.getItemgrpByUpId(upid).map { ItemGroupDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override suspend fun deleteItmgrp(itemGroup: ItemGroup) {
        withContext(ioDispatcher){
            itemGroupDao.delete(ItemGroupDataMapper.fromDomainToDb(itemGroup))
        }
    }

    override suspend fun deleteChildKategori(id: Int) {
        withContext(ioDispatcher){
            itemGroupDao.deleteChildKategori(id)
        }
    }

    override fun getLastItemgrp(): Flow<ItemGroup?> {
        return flow<ItemGroup> {
            val data = itemGroupDao.getLastItemgrp()
            data?.let { ItemGroupDataMapper.fromDbToDomain(it) }?.let { emit(it) }
        }.flowOn(ioDispatcher)
    }

}