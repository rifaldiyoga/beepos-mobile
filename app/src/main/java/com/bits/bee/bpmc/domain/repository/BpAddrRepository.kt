package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.BpAddrEntity
import com.bits.bee.bpmc.domain.model.BpAddr
import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface BpAddrRepository {

    suspend fun addUpdateBpAddr(bpaddr: BpAddrEntity)

    fun getBpAddrByBp(id: Int): Flow<BpAddr?>
}