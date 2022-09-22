package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SaleAddOnDao
import com.bits.bee.bpmc.domain.mapper.SaleAddOnDataMapper
import com.bits.bee.bpmc.domain.model.SaleAddOn
import com.bits.bee.bpmc.domain.repository.SaleAddOnRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class SaleAddOnRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val saleAddOnDao :SaleAddOnDao
) : SaleAddOnRepository {

    override suspend fun addSaleAddOn(saleAddOn: SaleAddOn) : Long {
        var id : Long
        withContext(defaultDispatcher){
            id = saleAddOnDao.insertSingle(SaleAddOnDataMapper.fromDomainToDb(saleAddOn))
        }
        return id
    }

    override fun getSaleAddonBySale(id: Int): Flow<Resource<SaleAddOn?>> {
        return flow {
            val data = saleAddOnDao.getSaleAddonBySale(id)
            data?.let {
                emit(Resource.success(SaleAddOnDataMapper.fromDbToDomain(data)))
            }
        }.flowOn(defaultDispatcher)
    }

}