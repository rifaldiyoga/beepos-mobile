package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.BpAcc
import kotlinx.coroutines.flow.Flow

interface BpAccRepository {

    suspend fun addUpdateBpAcc(bpaddr: BpAcc)

    fun getDefaultBpAccByBp(id: Int): Flow<List<BpAcc>>
}