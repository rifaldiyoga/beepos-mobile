package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemDummyDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.ItemDummyResponse
import com.bits.bee.bpmc.data.data_source.remote.response.VerifSmsResponse
import com.bits.bee.bpmc.domain.mapper.ItemDummyDummyDataMapper
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.repository.ItemDummyRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.Resource
import com.squareup.okhttp.MediaType
import com.squareup.okhttp.RequestBody
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
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
        val name = itemDummy.name.toRequestBody("text/plain".toMediaTypeOrNull())
        val itemtype = itemDummy.itemTypeCode.toRequestBody("text/plain".toMediaTypeOrNull())
        val itemgroup = ("Makanan").toRequestBody("text/plain".toMediaTypeOrNull())
        val price = itemDummy.price.toRequestBody("text/plain".toMediaTypeOrNull())
        val unit = ("PCS").toRequestBody("text/plain".toMediaTypeOrNull())
        val body : MultipartBody.Part? = null
        return object : NetworkBoundResource<ItemDummyResponse>(){
            override fun createCall(): Flow<ApiResponse<ItemDummyResponse>> {
                return apiUtils.getItemDummyApiService().postItemDummy(name, itemtype, itemgroup, price, unit, body)
            }
        }.getAsFlow()
    }

    override fun getLastId(): Flow<ItemDummy> {
        return flow<ItemDummy> {
            val data = itemDummyDao.getLastId()
            emit(ItemDummyDummyDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override suspend fun deleteItemDummy(itemDummy: ItemDummy) {
        withContext(ioDispatcher){
            itemDummyDao.delete(ItemDummyDummyDataMapper.fromDomainToDb(itemDummy))
        }
    }

//    override fun postItemDummy(itemDummy: ItemDummy): Flow<Resource<ItemDummyResponse>> {
////        return object : NetworkBoundResource<ItemDummyResponse>(){
////            override fun createCall(): Flow<ApiResponse<ItemDummyResponse>> {
////                return apiUtils.getItemDummyApiService().postItemDummy()
////            }
////        }.getAsFlow()
//    }

}