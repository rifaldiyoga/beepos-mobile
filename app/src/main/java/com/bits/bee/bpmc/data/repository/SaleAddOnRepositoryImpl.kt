package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SaleAddOnDao
import com.bits.bee.bpmc.domain.mapper.SaleAddOnDataMapper
import com.bits.bee.bpmc.domain.model.SaleAddOn
import com.bits.bee.bpmc.domain.repository.SaleAddOnRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class SaleAddOnRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val saleAddOnDao :SaleAddOnDao
) : SaleAddOnRepository {

    override suspend fun addSaleAddOn(saleAddOn: SaleAddOn) {
        withContext(defaultDispatcher){
            saleAddOnDao.insertSingle(SaleAddOnDataMapper.fromDomainToDb(saleAddOn))
        }
    }

}