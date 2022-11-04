package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.SaleCrcv
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 20/07/22.
 */
interface SaleCrcvRepository {

    suspend fun addSaleCrcv(saleCrcv: SaleCrcv)

    fun getSalecrcvBySale(id: Int): Flow<List<SaleCrcv>>

}