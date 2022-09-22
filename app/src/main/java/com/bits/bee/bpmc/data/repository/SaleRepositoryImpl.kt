package com.bits.bee.bpmc.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.bits.bee.bpmc.data.data_source.local.dao.SaleDao
import com.bits.bee.bpmc.domain.mapper.SaleDataMapper
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Resource
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

    override fun getLatestSaleList(query : String, isDraft: Boolean): Flow<PagingData<Sale>> =  Pager(
        config = PagingConfig(
            pageSize = BPMConstants.BPM_LIMIT_PAGINATION,
            maxSize = BPMConstants.BPM_MAX_PAGINATION,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            saleDao.getLatestSaleList(query, isDraft)
        }
    ).flow.mapLatest {
        it.map { SaleDataMapper.fromDbToDomain(it) }
    }.flowOn(defaultDispatcher)

    override fun getLatestDraftList(): Flow<List<Sale>> = flow {
        val saleList = saleDao.getLatestDraftList()
        emit(saleList.map { SaleDataMapper.fromDbToDomain(it) } )
    }.flowOn(defaultDispatcher)

    override fun getSaleByPosses(id: Int): Flow<Resource<List<Sale>>> {
        return flow {
            val data = saleDao.getSaleByPosses(id).map { SaleDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
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
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getTotalPaidDebit(id: Int): Flow<BigDecimal> {
        return flow {
            val data = saleDao.getTotalPaidDebit(id)
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getTotalPaidKredit(id: Int): Flow<BigDecimal> {
        return flow {
            val data = saleDao.getTotalPaidKredit(id)
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getTotalPaidGopay(id: Int): Flow<BigDecimal> {
        return flow {
            val data = saleDao.getTotalPaidGopay(id)
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaleHaventUploaded(
        limit_trx: Long,
        saledlist: List<Int>
    ): Flow<Resource<List<Sale>>> {
        return flow {
            val delimiter = ","
            val result = saledlist.joinToString(delimiter)
            val data = saleDao.getSaleHaventUploaded(limit_trx, result).map { SaleDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(defaultDispatcher)
    }

    override suspend fun updateNewIdCust(oldIdCust: Int, idCust: Int) {
        withContext(defaultDispatcher){
            saleDao.updateNewIdCust(oldIdCust, idCust)
        }
    }

    override fun getSaleById(id: Int): Flow<Resource<Sale>> {
        return flow {
            val data = saleDao.getSaleById(id)
            emit(Resource.success(SaleDataMapper.fromDbToDomain(data)))
        }.flowOn(defaultDispatcher)
    }

    override fun getSaleNotUploaded(): Flow<Resource<List<Sale>>> {
        return flow {
            val data = saleDao.getSaleNotUploaded().map { SaleDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(defaultDispatcher)
    }


}