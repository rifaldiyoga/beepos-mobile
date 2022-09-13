package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PromoMultiDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.PromoMultiResponse
import com.bits.bee.bpmc.domain.mapper.PromoMultiDataMapper
import com.bits.bee.bpmc.domain.model.PromoMulti
import com.bits.bee.bpmc.domain.repository.PromoMultiRepository
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
class PromoMultiRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val promoMultiDao: PromoMultiDao,
    private val ioDispatcher: CoroutineDispatcher
) : PromoMultiRepository {

    override fun getLatestPromoMulti(): Flow<Resource<List<PromoMulti>>> {
        return object : NetworkDatabaseBoundResource<List<PromoMulti>, PromoMultiResponse>(){
            override suspend fun loadFormDB(): List<PromoMulti> {
                return promoMultiDao.getPromoMultiList().map { PromoMultiDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<PromoMulti>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<PromoMultiResponse>> {
                return apiUtils.getPromoApiService().getPromoMulti()
            }

            override suspend fun saveCallResult(data: PromoMultiResponse) {
                promoMultiDao.insertBulk(data.data.map { PromoMultiDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }

    override fun getPromoMultiByPromo(promoId: Int): Flow<List<PromoMulti>> = flow {
        emit(promoMultiDao.getPromoMultiByPromo(promoId).map { PromoMultiDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getSyaratPromoMultiByPromo(promoId: Int): Flow<List<PromoMulti>> = flow {
        emit(promoMultiDao.getSyaratPromoMultiByPromo(promoId).map { PromoMultiDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getOfferPromoMultiByPromo(promoId: Int): Flow<List<PromoMulti>> = flow {
        emit(promoMultiDao.getOfferPromoMultiByPromo(promoId).map { PromoMultiDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getBranchPromoMultiByPromo(
        promoId: Int,
        branchId: Int
    ): Flow<List<PromoMulti>> = flow {
        emit(promoMultiDao.getBranchPromoMultiByPromo(promoId, branchId).map { PromoMultiDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

}