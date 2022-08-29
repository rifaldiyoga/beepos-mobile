package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SaleAddOnDDao
import com.bits.bee.bpmc.data.data_source.local.dao.SaledDao
import com.bits.bee.bpmc.domain.mapper.RankItemDataMapper
import com.bits.bee.bpmc.domain.mapper.SaleAddOnDDataMapper
import com.bits.bee.bpmc.domain.mapper.SaledDataMapper
import com.bits.bee.bpmc.domain.model.RankItem
import com.bits.bee.bpmc.domain.model.SaleAddOnD
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.SaleAddOnDRepository
import com.bits.bee.bpmc.domain.repository.SaledRepository
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
class SaleAddOnDRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val saleAddOnDDao: SaleAddOnDDao
) : SaleAddOnDRepository {
    override suspend fun addSaleAddOnD(saleAddOnDList: List<SaleAddOnD>) {
        withContext(defaultDispatcher){
            saleAddOnDDao.insertBulk(saleAddOnDList.map { SaleAddOnDDataMapper.fromDomainToDb(it) })
        }
    }

}