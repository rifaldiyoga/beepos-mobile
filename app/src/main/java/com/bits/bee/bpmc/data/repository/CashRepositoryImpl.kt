package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.CashDao
import com.bits.bee.bpmc.data.data_source.local.model.CashEntity
import com.bits.bee.bpmc.domain.mapper.CashDataMapper
import com.bits.bee.bpmc.domain.model.Cash
import com.bits.bee.bpmc.domain.repository.CashRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CashRepositoryImpl @Inject constructor(
    private val cashDao: CashDao,
    private val defaultDispatcher: CoroutineDispatcher
): CashRepository {

    override suspend fun addCash(cashEntity: CashEntity) {
        withContext(defaultDispatcher){
            cashDao.insertSingle(cashEntity)
        }
    }

    override fun getLastId(): Flow<Cash?> {
        return flow {
            val data = cashDao.getLastId()
            emit(CashDataMapper.fromDbToDomain(data))
        }.flowOn(defaultDispatcher)
    }

    override fun getActiveCash(idPosses: Long): Flow<Cash?> {
        return flow<Cash?> {
            val data = cashDao.getActiveCash(idPosses)
            emit(CashDataMapper.fromDbToDomain(data))
        }.flowOn(defaultDispatcher)
    }

}