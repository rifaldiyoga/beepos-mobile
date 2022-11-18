package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.BpAccEntity
import com.bits.bee.bpmc.domain.model.BpAcc
import kotlinx.coroutines.flow.Flow

interface BpAccRepository {

    suspend fun addUpdateBpAcc(bpaddr: BpAccEntity)

    fun getDefaultBpAccByBp(id: Int): Flow<List<BpAcc>>
}