package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.CashAEntity
import com.bits.bee.bpmc.domain.model.CashA
import kotlinx.coroutines.flow.Flow

interface CashARepository {

    suspend fun addCashA(cashAEntity: CashAEntity)

    fun getLastCasha(): Flow<List<CashA>>

    fun getCashAByCash(cashId : Int) : Flow<List<CashA>>

    fun getCashAByRefId(refId : Int, refType : String): Flow<CashA?>

    suspend fun updateCasha(cashA: CashA)

}