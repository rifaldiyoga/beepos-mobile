package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PromoDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse
import com.bits.bee.bpmc.domain.mapper.PromoDataMapper
import com.bits.bee.bpmc.domain.model.Promo
import com.bits.bee.bpmc.domain.repository.PromoRepository
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
class PromoRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val promoDao: PromoDao,
    private val ioDispatcher: CoroutineDispatcher
) : PromoRepository{

    override fun getLatestPromo(): Flow<Resource<List<Promo>>> {
        return object : NetworkDatabaseBoundResource<List<Promo>, PromoResponse>(){
            override suspend fun loadFormDB(): List<Promo> {
                return promoDao.getPromoList().map { PromoDataMapper.fromDbToDomain(it) }
            }

            override fun shouldFetch(data: List<Promo>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<PromoResponse>> {
                return apiUtils.getPromoApiService().getPromo()
            }

            override suspend fun saveCallResult(data: PromoResponse) {
                promoDao.insertBulk(data.data.map { PromoDataMapper.fromNetworkToDb(it) })
            }
        }.getAsFlow()
    }

    override fun getActivePromoList(): Flow<List<Promo>> = flow {
        emit(promoDao.getPromoList().map { PromoDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getPromoById(id: Int): Flow<Promo> {
        return flow {
            val data = promoDao.getPromoById(id)
            emit(PromoDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

}