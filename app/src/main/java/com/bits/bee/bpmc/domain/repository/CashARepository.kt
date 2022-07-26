package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.CashAEntity
import com.bits.bee.bpmc.domain.model.CashA
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CashARepository {
    suspend fun addCashA(cashAEntity: CashAEntity)

    fun getLastCasha(): Flow<Resource<List<CashA>>>
}