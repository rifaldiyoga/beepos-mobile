package com.bits.bee.bpmc.data.repository

import androidx.paging.*
import com.bits.bee.bpmc.data.data_source.local.dao.SaleDao
import com.bits.bee.bpmc.data.data_source.remote.model.LineChartData
import com.bits.bee.bpmc.domain.mapper.SaleDataMapper
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.utils.BPMConstants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class SaleRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val saleDao: SaleDao
) : SaleRepository {

    override suspend fun addSale(sale: Sale) : Long{
        var id: Long
        withContext(defaultDispatcher){
            val saleNew = SaleDataMapper.fromDomainToDb(sale)
            id = saleDao.insertSingle(saleNew)
        }
        return id
    }

    override suspend fun deleteSale(sale: Sale) {
        withContext(defaultDispatcher){
            saleDao.delete(SaleDataMapper.fromDomainToDb(sale))
        }
    }

    override suspend fun updateSale(sale: Sale) {
        withContext(defaultDispatcher) {
            saleDao.update(SaleDataMapper.fromDomainToDb(sale))
        }
    }

    override fun getLatestSaleList(query : String, isDraft: Boolean, channelList : List<Int>, startDate : Long, endDate : Long): Flow<PagingData<Sale>> =  Pager(
        config = PagingConfig(
            pageSize = BPMConstants.BPM_LIMIT_PAGINATION,
            maxSize = BPMConstants.BPM_MAX_PAGINATION,
            enablePlaceholders = true,
            initialLoadSize = BPMConstants.BPM_MAX_PAGINATION,
        ),
        pagingSourceFactory = {
            if(channelList.isNotEmpty())
                saleDao.getLatestSaleList(query, isDraft, channelList, startDate, endDate)
            else
                saleDao.getLatestSaleList(query, isDraft, startDate, endDate)
        }
    ).flow.mapLatest {
        it.map { SaleDataMapper.fromDbToDomain(it) }
    }.flowOn(defaultDispatcher)

    override fun getLatestDraftList(): Flow<List<Sale>> = flow {
        val saleList = saleDao.getLatestDraftList()
        emit(saleList.map { SaleDataMapper.fromDbToDomain(it) } )
    }.flowOn(defaultDispatcher)

    override fun getSaleByPosses(id: Int): Flow<List<Sale>> {
        return flow {
            val data = saleDao.getSaleByPosses(id).map { SaleDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaleByPosses(id: Int, isVoid: Boolean, termType: String): Flow<List<Sale>> {
        return flow {
            val data = saleDao.getSaleByPosses(id, isVoid, termType).map { SaleDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaleByPossesGroupChannel(id: Int): Flow<List<Sale>> {
        return flow {
            val data = saleDao.getSaleByPossesGroupChannel(id).map { SaleDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getTotalNota(id: Int): Flow<BigDecimal> {
        return flow {
            val data = saleDao.getTotalNota(id)
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getTotalNotaVoid(id: Int): Flow<BigDecimal> {
        return flow {
            val data = saleDao.getTotalNotaVoid(id)
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getTotalPaidTunai(id: Int): Flow<BigDecimal> {
        return flow {
            val data = saleDao.getTotalPaidTunai(id)
            if (data != null)
                emit(data)
            else
                emit(BigDecimal.ZERO)

        }.flowOn(defaultDispatcher)
    }

    override fun getTotalPaidDebit(id: Int): Flow<BigDecimal> {
        return flow {
            val data = saleDao.getTotalPaidDebit(id)
            if (data != null)
                emit(data)
            else
                emit(BigDecimal("0"))

        }.flowOn(defaultDispatcher)
    }

    override fun getTotalPaidKredit(id: Int): Flow<BigDecimal> {
        return flow {
            val data = saleDao.getTotalPaidKredit(id)
            if (data != null)
                emit(data)
            else
                emit(BigDecimal.ZERO)

        }.flowOn(defaultDispatcher)
    }

    override fun getTotalPaidGopay(id: Int): Flow<BigDecimal> {
        return flow {
            val data = saleDao.getTotalPaidGopay(id)
            if (data != null)
                emit(data)
            else
                emit(BigDecimal.ZERO)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaleHaventUploaded(limit_trx: Int, ): Flow<List<Sale>> {
        return flow {
            val data = saleDao.getSaleHaventUploaded(limit_trx).map { SaleDataMapper.fromDbToDomain(it) }
            emit((data))
        }.flowOn(defaultDispatcher)
    }

    override suspend fun updateNewIdCust(oldIdCust: Int, idCust: Int) {
        withContext(defaultDispatcher){
            saleDao.updateNewIdCust(oldIdCust, idCust)
        }
    }

    override fun getSaleById(id: Int): Flow<Sale?> {
        return flow {
            val data = saleDao.getSaleById(id)
            emit(data?.let { SaleDataMapper.fromDbToDomain(data)})
        }.flowOn(defaultDispatcher)
    }

    override fun getSaleNotUploaded(): Flow<List<Sale>> {
        return flow {
            val data = saleDao.getSaleNotUploaded().map { SaleDataMapper.fromDbToDomain(it) }
            emit((data))
        }.flowOn(defaultDispatcher)
    }

    override fun sumQtyByHour(id: Int, hour: String): Flow<LineChartData> {
        return flow {
            val data = saleDao.sumQtyByHour(id, hour)
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaleByPossesGroupByBp(id: Int): Flow<List<Sale>> {
        return flow {
            val data = saleDao.getSaleByPossesGroupByBp(id).map { SaleDataMapper.fromDbToDomain(it) }
            emit((data))
        }.flowOn(defaultDispatcher)
    }

    override fun getDraftCount(): Flow<Int> {
        return flow {
            val data = saleDao.getCountDraft()
            emit((data))
        }.flowOn(defaultDispatcher)
    }

}