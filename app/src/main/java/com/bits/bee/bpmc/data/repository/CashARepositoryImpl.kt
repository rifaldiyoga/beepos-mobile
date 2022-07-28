package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.CashADao
import com.bits.bee.bpmc.data.data_source.local.model.CashAEntity
import com.bits.bee.bpmc.domain.repository.CashARepository
import kotlinx.coroutines.CoroutineDispatcher
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
            cashADao.insert(cashAEntity)
        }
    }

}