package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SaleDao
import com.bits.bee.bpmc.data.data_source.local.model.SaleEntity
import com.bits.bee.bpmc.domain.mapper.SaleDataMapper
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaleRepository
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
class SaleRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val saleDao: SaleDao
) : SaleRepository {

    override suspend fun addSale(sale: Sale) : Long{
        var id : Long = 1
        withContext(defaultDispatcher){
            val saleNew = SaleDataMapper.fromDomainToDb(sale)

            id = saleDao.insertSingle(saleNew)
        }
        return id
    }

    override fun getLatestSaleList(): Flow<List<Sale>> = flow {
        emit(saleDao.getLatestSaleList().map { SaleDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)

    override fun getLatestDraftList(): Flow<List<Sale>> = flow {
        val saleList = saleDao.getLatestDraftList()
        if(saleList.size <= 5)
            emit(saleList.map { SaleDataMapper.fromDbToDomain(it) } )
        else
            emit(saleList.slice(0..4).map { SaleDataMapper.fromDbToDomain(it) })
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


}