package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemDummyDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemDummyResponse
import com.bits.bee.bpmc.domain.mapper.ItemDummyDummyDataMapper
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.repository.ItemDummyRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class ItemDummyRepositoryImpl @Inject constructor(
    private val itemDummyDao: ItemDummyDao,
    private val ioDispatcher: CoroutineDispatcher,
    private val apiUtils: ApiUtils
) : ItemDummyRepository{

    override fun getItemDummyList(): Flow<Resource<List<ItemDummy>>> = flow {
        emit(Resource.loading())
        emit(Resource.success(itemDummyDao.getItemList().map { ItemDummyDummyDataMapper.fromDbToDomain(it) }))
    }.flowOn(ioDispatcher)

    override suspend fun addItemDummy(itemDummy: ItemDummy): Flow<Long> = flow {
        emit(itemDummyDao.insertSingle(ItemDummyDummyDataMapper.fromDomainToDb(itemDummy)))
    }.flowOn(ioDispatcher)

    override fun postItemDummy(itemDummy: ItemDummy): Flow<Resource<ItemDummyResponse>> {
        TODO("Not yet implemented")
    }

//    override fun postItemDummy(itemDummy: ItemDummy): Flow<Resource<ItemDummyResponse>> {
////        return object : NetworkBoundResource<ItemDummyResponse>(){
////            override fun createCall(): Flow<ApiResponse<ItemDummyResponse>> {
////                return apiUtils.getItemDummyApiService().postItemDummy()
////            }
////        }.getAsFlow()
//    }

}