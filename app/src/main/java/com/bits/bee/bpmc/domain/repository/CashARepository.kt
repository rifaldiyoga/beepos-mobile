package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.CashAEntity

interface CashARepository {
    suspend fun addCashA(cashAEntity: CashAEntity)
}