package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.CashADao
import com.bits.bee.bpmc.data.data_source.local.model.CashAEntity
import com.bits.bee.bpmc.domain.mapper.CashADataMapper
import com.bits.bee.bpmc.domain.model.CashA
import com.bits.bee.bpmc.domain.repository.CashARepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CashARepositoryImpl @Inject constructor(
    private val cashADao: CashADao,
    private val defaultDispatcher: CoroutineDispatcher
): CashARepository {

    override suspend fun addCashA(cashAEntity: CashAEntity) {
        withContext(defaultDispatcher) {
            val cashA = cashADao.getCashAByRef(cashAEntity.refId, cashAEntity.refType)
            cashA?.let {
                cashAEntity.id = it.id
            }
            cashADao.insertSingle(cashAEntity)
        }
    }

    override fun getLastCasha(): Flow<List<CashA>> {
        return flow{
            val data = cashADao.getLastCasha().map { CashADataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getCashAByCash(cashId: Int): Flow<List<CashA>> = flow {
        val data = cashADao.getCashAByCashId(cashId)
        emit(data.map { CashADataMapper.fromDbToDomain(it) } )
    }.flowOn(defaultDispatcher)

    override fun getCashAByRefId(refId: Int, refType: String): Flow<CashA?> {
        return flow {
            val data = cashADao.getCashAByRefId(refId, refType)
            emit(data?.let { CashADataMapper.fromDbToDomain(data) })
        }.flowOn(defaultDispatcher)
    }

    override suspend fun updateCasha(cashA: CashA) {
        withContext(defaultDispatcher){
            cashADao.update(CashADataMapper.fromDomainToDb(cashA))
        }
    }

}