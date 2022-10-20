package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemDao
import com.bits.bee.bpmc.data.data_source.local.dao.VariantDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.VariantResponse
import com.bits.bee.bpmc.domain.mapper.ItemDataMapper
import com.bits.bee.bpmc.domain.mapper.VariantDataMapper
import com.bits.bee.bpmc.domain.model.Variant
import com.bits.bee.bpmc.domain.model.VariantWithItem
import com.bits.bee.bpmc.domain.repository.VariantRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class VariantRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val variantDao: VariantDao,
    private val itemDao: ItemDao,
    private val ioDispatcher: CoroutineDispatcher
) : VariantRepository{

    override fun getLatestVariantList(): Flow<Resource<List<Variant>>> {
        return object : NetworkDatabaseBoundResource<List<Variant>, VariantResponse>(){
            override suspend fun loadFormDB(): List<Variant> {
                return variantDao.getVariantList().map { VariantDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<Variant>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<VariantResponse>> {
                return apiUtils.getVariantApiService().getVariant()
            }

            override suspend fun saveCallResult(data: VariantResponse) {
                variantDao.insertBulk(data.variantModels.map { VariantDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }

    override fun getVariant(variantId: Int): Flow<VariantWithItem> = flow {
        variantDao.getVariantById(variantId)?.let { variantEntity ->
            val variant = VariantWithItem(
                VariantDataMapper.fromDbToDomain(variantEntity),
                itemDao.getItemByVariant(variantId).map { ItemDataMapper.fromDbToDomain(it) }
            )
            emit(variant)
        }
    }.flowOn(ioDispatcher)

    override suspend fun updateFavorit(variantId: Int, fav: Boolean) {
        withContext(ioDispatcher){
            variantDao.updateFavoritVariant(variantId, fav)
        }
    }

}