package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SaleCrcvDao
import com.bits.bee.bpmc.domain.mapper.SaleCrcvDataMapper
import com.bits.bee.bpmc.domain.model.SaleCrcv
import com.bits.bee.bpmc.domain.repository.SaleCrcvRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 20/07/22.
 */
class SaleCrcvRepositoryImpl @Inject constructor(
    private val saleCrcvDao: SaleCrcvDao,
    private val defDispatcher: CoroutineDispatcher
) : SaleCrcvRepository {

    override suspend fun addSaleCrcv(saleCrcv: SaleCrcv) {
        withContext(defDispatcher){
            saleCrcvDao.insertSingle(SaleCrcvDataMapper.fromDomainToDb(saleCrcv))
        }
    }

    override fun getSalecrcvBySale(id: Int): Flow<List<SaleCrcv>> {
        return flow {
            val data = saleCrcvDao.getSalecrcvBySale(id).map { SaleCrcvDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defDispatcher)
    }

    override fun getSalecrcvByPosses(possesId: Int, rcvType: String): Flow<List<SaleCrcv>> {
        return flow {
            val data = saleCrcvDao.getSalecrcvBySale(possesId, rcvType).map { SaleCrcvDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defDispatcher)
    }

    override fun getTotalSurchargeByPossesNonCashAll(
        possesId: Int,
        termType: String
    ): Flow<BigDecimal?> = flow {
        emit(saleCrcvDao.getTotalSurchargeByPossesNonCashAll(possesId, termType))
    }.flowOn(defDispatcher)

    override fun getTotalSurchargeByPossesNonCash(
        possesId: Int,
        termType: String
    ): Flow<BigDecimal?> = flow {
        emit(saleCrcvDao.getTotalSurchargeByPossesNonCash(possesId, termType))
    }.flowOn(defDispatcher)

    override fun getTotalSurchargeByPossesVoid(possesId: Int): Flow<BigDecimal?> = flow {
        emit(saleCrcvDao.getTotalSurchargeByPosses(possesId, 1))
    }.flowOn(defDispatcher)

    override fun getTotalSurchargeByPosses(possesId: Int): Flow<BigDecimal?> = flow {
        emit(saleCrcvDao.getTotalSurchargeByPosses(possesId, 0))
    }.flowOn(defDispatcher)


}