package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SaledDao
import com.bits.bee.bpmc.domain.mapper.RankItemDataMapper
import com.bits.bee.bpmc.domain.mapper.SaledDataMapper
import com.bits.bee.bpmc.domain.model.RankItem
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.SaledRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class SaledRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val saledDao: SaledDao
) : SaledRepository {

   private lateinit var mSubtotal: BigDecimal

    override suspend fun addSaled(saledList: List<Saled>) {
        withContext(defaultDispatcher){
            val saledNew = saledList.map {
                SaledDataMapper.fromDomainToDb(it)
            }
            saledDao.insertBulk(saledNew)
        }
    }

    override fun getSaledList(saleId: Int): Flow<List<Saled>> = flow {
        val saledList = saledDao.getSaledList(saleId)
        emit(saledList.map { SaledDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)

    override fun getRankItem(possesId: Int): Flow<List<RankItem>> {
        return flow {
            val rankItem = saledDao.getRankItem(possesId).map { RankItemDataMapper.fromDbToDomain(it) }
            emit(rankItem)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaledDeletedItem(): Flow<List<Saled>> {
        return flow {
            val data = saledDao.getSaledDeletedItem().map { SaledDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun queryByPenjualan(): Flow<List<Saled>> {
        return flow {
            val data = saledDao.queryByPenjualan().map { SaledDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaledTotal(id: Int, startDate: Long, endDate: Long): Flow<List<Saled>> {
        return flow{
            val data = saledDao.sumTotalByItem(id, startDate, endDate).map { SaledDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getStokByItem(id: Int, startDate: Long, endDate: Long): Flow<BigDecimal> {
        var qty = BigDecimal.ZERO
        return flow<BigDecimal> {
            val data = saledDao.sumStokByItem(id, startDate, endDate).map { SaledDataMapper.fromDbToDomain(it) }
            for (saled in data){
                qty.add(saled.qty)
            }
            emit(qty)
        }.flowOn(defaultDispatcher)
    }
}