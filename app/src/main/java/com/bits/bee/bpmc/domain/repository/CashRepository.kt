package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.CashEntity
import com.bits.bee.bpmc.domain.model.Cash
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CashRepository {
    suspend fun addCash(cashEntity: CashEntity)

    fun getLastId(): Flow<Resource<Cash>>
}