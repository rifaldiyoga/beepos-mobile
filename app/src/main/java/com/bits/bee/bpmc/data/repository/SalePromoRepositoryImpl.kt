package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SalePromoDao
import com.bits.bee.bpmc.domain.mapper.SalePromoDataMapper
import com.bits.bee.bpmc.domain.model.SalePromo
import com.bits.bee.bpmc.domain.repository.SalePromoRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SalePromoRepositoryImpl @Inject constructor(
    private val salePromoDao: SalePromoDao,
    private val ioDispatcher: CoroutineDispatcher
): SalePromoRepository {
    override fun getSalePromoBySale(id: Int): Flow<Resource<List<SalePromo>>> {
        return flow {
            val data = salePromoDao.getSalePromoBySale(id).map { SalePromoDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(ioDispatcher)
    }
}